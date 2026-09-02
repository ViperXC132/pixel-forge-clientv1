package com.pixelforge.module;

import com.pixelforge.PixelForgeClient;
import com.pixelforge.module.modules.hud.*;
import com.pixelforge.module.modules.visual.*;
import com.pixelforge.module.modules.utility.*;
import com.pixelforge.module.modules.performance.*;
import com.pixelforge.module.modules.movement.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // HUD
        register(new FpsCounterModule());
        register(new CpsCounterModule());
        register(new CoordsModule());
        register(new ArmorStatusModule());
        register(new PotionEffectsModule());
        register(new SpeedDisplayModule());
        register(new CompassClockModule());
        register(new PingTpsModule());
        register(new KeystrokesModule());
        register(new ToggleSprintIndicatorModule());
        register(new ModListModule());
        register(new BiomeChunkModule());
        register(new LightLevelModule());
        register(new MemoryEntityModule());
        register(new ReachDisplayModule());

        // Visual
        register(new FullbrightModule());
        register(new CustomNametags());
        register(new HitColorModule());
        register(new TimeWeatherModule());
        register(new CrosshairModule());
        register(new MobHealthbarModule());
        register(new BlockOutlineModule());
        register(new ArmorDurabilityModule());
        register(new NoParticlesModule());

        // Utility
        register(new ZoomModule());
        register(new FreeLookModule());
        register(new AutoRespawnModule());
        register(new AntiBlindModule());
        register(new NoHurtCamModule());
        register(new BetterChatModule());
        register(new FastPlaceModule());
        register(new MidClickModule());
        register(new AutoToolModule());
        register(new AutoEatModule());
        register(new PotionAlertModule());
        register(new BorderAlertModule());
        register(new ServerInfoModule());
        register(new ScreenshotManagerModule());
        register(new FovChangerModule());

        // Performance
        register(new DynamicFpsModule());
        register(new EntityCullingModule());
        register(new SmartRenderDistanceModule());
        register(new ParticleLimiterModule());
        register(new MemoryCleanerModule());

        // Movement
        register(new ToggleSprintModule());
        register(new ToggleSneakModule());
    }

    public void register(Module m) { modules.add(m); }

    public <T extends Module> T get(Class<T> clazz) {
        for (Module m : modules)
            if (clazz.isInstance(m)) return clazz.cast(m);
        return null;
    }

    public List<Module> getAll() { return modules; }

    public List<Module> getByCategory(Category cat) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) if (m.getCategory() == cat) result.add(m);
        return result;
    }

    public void loadAll() {
        for (Module m : modules) PixelForgeClient.configManager.load(m);
    }

    public void saveAll() {
        for (Module m : modules) PixelForgeClient.configManager.save(m);
    }
}
