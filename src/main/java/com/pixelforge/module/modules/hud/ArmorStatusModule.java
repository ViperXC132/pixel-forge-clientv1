package com.pixelforge.module.modules.hud;

import com.pixelforge.hud.HudModule;
import com.pixelforge.module.Category;
import com.pixelforge.util.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ArmorStatusModule extends HudModule {
    public ArmorStatusModule() {
        super("Armor Status", Category.HUD, 2, 38);
    }

    @Override
    public void renderHud(DrawContext ctx, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        RenderUtil.drawText(ctx, "Armor Status: ...", element.getX(), element.getY(), 0xFFFFFFFF, true);
    }
}
