package com.pixelforge.module.modules.hud;

import com.pixelforge.hud.HudModule;
import com.pixelforge.module.Category;
import com.pixelforge.util.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class CpsCounterModule extends HudModule {
    public CpsCounterModule() {
        super("CPS Counter", Category.HUD, 2, 14);
    }

    @Override
    public void renderHud(DrawContext ctx, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        RenderUtil.drawText(ctx, "CPS Counter: ...", element.getX(), element.getY(), 0xFFFFFFFF, true);
    }
}
