package com.pixelforge;

import com.pixelforge.module.ModuleManager;
import com.pixelforge.event.EventBus;
import com.pixelforge.config.ConfigManager;
import com.pixelforge.keybind.KeybindManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelForgeClient implements ClientModInitializer {
    public static final String MOD_ID = "pixelforge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ModuleManager moduleManager;
    public static ConfigManager configManager;
    public static KeybindManager keybindManager;

    @Override
    public void onInitializeClient() {
        LOGGER.info("PixelForge Client initializing...");
        configManager = new ConfigManager();
        moduleManager = new ModuleManager();
        keybindManager = new KeybindManager();
        EventBus.init();
        moduleManager.loadAll();
        LOGGER.info("PixelForge Client ready!");
    }
}
