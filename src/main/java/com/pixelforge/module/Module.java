package com.pixelforge.module;

import net.minecraft.client.util.InputUtil;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int keyCode;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
        this.keyCode = InputUtil.UNKNOWN_KEY.getCode();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable(); else onDisable();
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) onEnable(); else onDisable();
    }
    public int getKeyCode() { return keyCode; }
    public void setKeyCode(int keyCode) { this.keyCode = keyCode; }
}
