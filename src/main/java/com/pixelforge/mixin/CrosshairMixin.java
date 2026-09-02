package com.pixelforge.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class CrosshairMixin {
    @Inject(at = @At("HEAD"), method = "renderCrosshair", cancellable = true)
    private void onRenderCrosshair(DrawContext ctx, net.minecraft.client.render.RenderTickCounter counter, CallbackInfo ci) {
        // Custom crosshair render — Phase 4
    }
}
