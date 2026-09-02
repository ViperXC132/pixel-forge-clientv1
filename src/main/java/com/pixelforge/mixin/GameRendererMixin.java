package com.pixelforge.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(at = @At("HEAD"), method = "getFov", cancellable = true)
    private void onGetFov(net.minecraft.client.render.Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
        // FOV changer — Phase 4
    }
}
