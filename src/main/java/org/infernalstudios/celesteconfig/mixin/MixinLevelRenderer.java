package org.infernalstudios.celesteconfig.mixin;

import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

@Mixin(LevelRenderer.class)
public class MixinLevelRenderer {

	@Inject(method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/math/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
	private void celesteConfig$scaleSun$before(PoseStack matrices, Matrix4f matrix, float tickDelta, Camera cemera, boolean applyFog, Runnable runnable, CallbackInfo ci, ISkyRenderHandler renderHandler, FogType fogtype, Entity $$9, Vec3 vec3, float f10, float f, float f1, BufferBuilder bufferbuilder, ShaderInstance shaderinstance, float afloat[], float f11, Matrix4f matrix4f1) {
		matrix4f1.multiply(Matrix4f.createScaleMatrix((float) CelestialConfigOptions.getSunWidthScalar(), 1.0F, (float) CelestialConfigOptions.getSunHeightScalar()));
	}

	@Inject(method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/math/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferUploader;end(Lcom/mojang/blaze3d/vertex/BufferBuilder;)V", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD)
	private void celesteConfig$scaleSun$after(PoseStack matrices, Matrix4f matrix, float tickDelta, Camera cemera, boolean applyFog, Runnable runnable, CallbackInfo ci, ISkyRenderHandler renderHandler, FogType fogtype, Entity $$9, Vec3 vec3, float f10, float f, float f1, BufferBuilder bufferbuilder, ShaderInstance shaderinstance, float afloat[], float f11, Matrix4f matrix4f1) {
		matrix4f1.multiply(Matrix4f.createScaleMatrix(1.0F / (float) CelestialConfigOptions.getSunWidthScalar(), 1.0F, 1.0F / (float) CelestialConfigOptions.getSunHeightScalar()));
	}

	@Inject(method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/math/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD)
	private void celesteConfig$scaleMoon$before(PoseStack matrices, Matrix4f matrix, float tickDelta, Camera cemera, boolean applyFog, Runnable runnable, CallbackInfo ci, ISkyRenderHandler renderHandler, FogType fogtype, Entity $$9, Vec3 vec3, float f10, float f, float f1, BufferBuilder bufferbuilder, ShaderInstance shaderinstance, float afloat[], float f11, Matrix4f matrix4f1) {
		matrix4f1.multiply(Matrix4f.createScaleMatrix((float) CelestialConfigOptions.getMoonWidthScalar(), 1.0F, (float) CelestialConfigOptions.getMoonHeightScalar()));
	}

	@Inject(method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/math/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferUploader;end(Lcom/mojang/blaze3d/vertex/BufferBuilder;)V", ordinal = 2), locals = LocalCapture.CAPTURE_FAILHARD)
	private void celesteConfig$scaleMoon$after(PoseStack matrices, Matrix4f matrix, float tickDelta, Camera cemera, boolean applyFog, Runnable runnable, CallbackInfo ci, ISkyRenderHandler renderHandler, FogType fogtype, Entity $$9, Vec3 vec3, float f10, float f, float f1, BufferBuilder bufferbuilder, ShaderInstance shaderinstance, float afloat[], float f11, Matrix4f matrix4f1) {
		matrix4f1.multiply(Matrix4f.createScaleMatrix(1.0F / (float) CelestialConfigOptions.getMoonWidthScalar(), 1.0F, 1.0F / (float) CelestialConfigOptions.getMoonHeightScalar()));
	}

}
