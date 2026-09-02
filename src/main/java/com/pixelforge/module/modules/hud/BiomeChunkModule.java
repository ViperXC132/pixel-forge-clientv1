package com.pixelforge.module.modules.hud;

import com.pixelforge.hud.HudModule;
import com.pixelforge.module.Category;
import com.pixelforge.util.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class BiomeChunkModule extends HudModule {
    public BiomeChunkModule() {
        super("Biome Chunk", Category.HUD, 2, 134);
    }

    @Override
    public void renderHud(DrawContext ctx, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        RenderUtil.drawText(ctx, "Biome Chunk: ...", element.getX(), element.getY(), 0xFFFFFFFF, true);
    }
}
