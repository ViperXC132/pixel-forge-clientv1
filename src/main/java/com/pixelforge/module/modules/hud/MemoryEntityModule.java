package com.pixelforge.module.modules.hud;

import com.pixelforge.hud.HudModule;
import com.pixelforge.module.Category;
import com.pixelforge.util.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class MemoryEntityModule extends HudModule {
    public MemoryEntityModule() {
        super("Memory Entity", Category.HUD, 2, 158);
    }

    @Override
    public void renderHud(DrawContext ctx, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        RenderUtil.drawText(ctx, "Memory Entity: ...", element.getX(), element.getY(), 0xFFFFFFFF, true);
    }
}
