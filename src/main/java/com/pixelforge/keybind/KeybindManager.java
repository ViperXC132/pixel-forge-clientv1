package com.pixelforge.keybind;

import com.pixelforge.PixelForgeClient;
import com.pixelforge.module.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindManager {
    public KeybindManager() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.currentScreen != null) return;
            long window = MinecraftClient.getInstance().getWindow().getHandle();
            for (Module m : PixelForgeClient.moduleManager.getAll()) {
                int key = m.getKeyCode();
                if (key == InputUtil.UNKNOWN_KEY.getCode()) continue;
                if (InputUtil.isKeyPressed(window, key)) {
                    // debounce handled by module logic - simple press check
                }
            }
        });
    }
}
