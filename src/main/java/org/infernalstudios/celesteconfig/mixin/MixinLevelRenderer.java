/**
 * Copyright 2022 Infernal Studios
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.infernalstudios.celesteconfig.mixin;

import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.math.vector.Matrix4f;

@Mixin(WorldRenderer.class)
public class MixinLevelRenderer {

	@Unique
	private Matrix4f originalCelestialMatrix;

	@ModifyVariable(method = "Lnet/minecraft/client/renderer/WorldRenderer;renderSky(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bind(Lnet/minecraft/util/ResourceLocation;)V", ordinal = 0, shift = Shift.BEFORE), index = 11)
	private Matrix4f celesteConfig$scaleSun(Matrix4f in) {
		originalCelestialMatrix = in.copy();
		Matrix4f copy = in.copy();
		copy.multiply(Matrix4f.createScaleMatrix((float) CelestialConfigOptions.getSunWidthScalar(), 1.0F, (float) CelestialConfigOptions.getSunHeightScalar()));
		return copy;
	}

	@ModifyVariable(method = "Lnet/minecraft/client/renderer/WorldRenderer;renderSky(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bind(Lnet/minecraft/util/ResourceLocation;)V", ordinal = 1, shift = Shift.BEFORE), index = 11)
	private Matrix4f celesteConfig$scaleMoon(Matrix4f in) {
		Matrix4f copy = originalCelestialMatrix.copy();
		copy.multiply(Matrix4f.createScaleMatrix((float) CelestialConfigOptions.getMoonWidthScalar(), 1.0F, (float) CelestialConfigOptions.getMoonHeightScalar()));
		originalCelestialMatrix = null;
		return copy;
	}

}
