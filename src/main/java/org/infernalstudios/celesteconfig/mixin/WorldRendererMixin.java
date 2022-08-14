package org.infernalstudios.celesteconfig.mixin;

import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.Matrix4f;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

	@Unique
	private Matrix4f originalCelestialMatrix;

	@ModifyVariable(method = "Lnet/minecraft/client/render/WorldRenderer;renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V", ordinal = 0), ordinal = 1)
	private Matrix4f celesteConfig$scaleSun(Matrix4f in) {
		originalCelestialMatrix = in.copy();
		Matrix4f copy = in.copy();
		copy.multiply(Matrix4f.scale(CelestialConfigOptions.getInstance().sunWidth, 1.0F, CelestialConfigOptions.getInstance().sunHeight));
		return copy;
	}

	@ModifyVariable(method = "Lnet/minecraft/client/render/WorldRenderer;renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V", ordinal = 1), ordinal = 1)
	private Matrix4f celesteConfig$scaleMoon(Matrix4f in) {
		Matrix4f copy = originalCelestialMatrix.copy();
		copy.multiply(Matrix4f.scale(CelestialConfigOptions.getInstance().moonWidth, 1.0F, CelestialConfigOptions.getInstance().moonHeight));
		originalCelestialMatrix = null;
		return copy;
	}

}
