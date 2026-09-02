package com.pixelforge.util;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.MinecraftClient;

public class RenderUtil {
    public static void drawRect(DrawContext ctx, int x, int y, int w, int h, int color) {
        ctx.fill(x, y, x + w, y + h, color);
    }

    public static void drawBorder(DrawContext ctx, int x, int y, int w, int h, int color) {
        ctx.fill(x, y, x + w, y + 1, color);
        ctx.fill(x, y + h - 1, x + w, y + h, color);
        ctx.fill(x, y, x + 1, y + h, color);
        ctx.fill(x + w - 1, y, x + w, y + h, color);
    }

    public static void drawText(DrawContext ctx, String text, int x, int y, int color, boolean shadow) {
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;
        if (shadow) ctx.drawTextWithShadow(tr, text, x, y, color);
        else ctx.drawText(tr, text, x, y, color, false);
    }

    public static int textWidth(String text) {
        return MinecraftClient.getInstance().textRenderer.getWidth(text);
    }

    public static int textHeight() {
        return MinecraftClient.getInstance().textRenderer.fontHeight;
    }
}
