package com.pixelforge.event;

import com.pixelforge.PixelForgeClient;
import com.pixelforge.module.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class EventBus {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            for (Module m : PixelForgeClient.moduleManager.getAll()) {
                if (m.isEnabled()) m.onTick();
            }
        });

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (PixelForgeClient.moduleManager == null) return;
            com.pixelforge.hud.HudRenderer.render(drawContext, tickDelta);
        });
    }
}
