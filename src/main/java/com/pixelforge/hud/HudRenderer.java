package com.pixelforge.hud;

import com.pixelforge.PixelForgeClient;
import com.pixelforge.module.Module;
import net.minecraft.client.gui.DrawContext;

public class HudRenderer {
    public static void render(DrawContext ctx, float tickDelta) {
        for (Module m : PixelForgeClient.moduleManager.getAll()) {
            if (m.isEnabled() && m instanceof HudModule) {
                ((HudModule) m).renderHud(ctx, tickDelta);
            }
        }
    }
}
