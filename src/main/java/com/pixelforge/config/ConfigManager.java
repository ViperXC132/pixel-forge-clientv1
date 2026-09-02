package com.pixelforge.config;

import com.google.gson.*;
import com.pixelforge.PixelForgeClient;
import com.pixelforge.module.Module;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.*;

public class ConfigManager {
    private final Path configDir;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ConfigManager() {
        configDir = FabricLoader.getInstance().getConfigDir().resolve("pixelforge");
        try { Files.createDirectories(configDir); } catch (IOException e) {
            PixelForgeClient.LOGGER.error("Failed to create config dir", e);
        }
    }

    public void save(Module module) {
        JsonObject obj = new JsonObject();
        obj.addProperty("enabled", module.isEnabled());
        obj.addProperty("keyCode", module.getKeyCode());
        Path file = configDir.resolve(module.getName().replace(" ", "_") + ".json");
        try (Writer w = Files.newBufferedWriter(file)) {
            gson.toJson(obj, w);
        } catch (IOException e) {
            PixelForgeClient.LOGGER.error("Failed to save config for " + module.getName(), e);
        }
    }

    public void load(Module module) {
        Path file = configDir.resolve(module.getName().replace(" ", "_") + ".json");
        if (!Files.exists(file)) return;
        try (Reader r = Files.newBufferedReader(file)) {
            JsonObject obj = gson.fromJson(r, JsonObject.class);
            if (obj.has("enabled")) module.setEnabled(obj.get("enabled").getAsBoolean());
            if (obj.has("keyCode")) module.setKeyCode(obj.get("keyCode").getAsInt());
        } catch (IOException e) {
            PixelForgeClient.LOGGER.error("Failed to load config for " + module.getName(), e);
        }
    }
}
