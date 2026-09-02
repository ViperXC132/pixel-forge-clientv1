package com.pixelforge.hud;

import com.pixelforge.module.Category;
import com.pixelforge.module.Module;
import net.minecraft.client.gui.DrawContext;

public abstract class HudModule extends Module {
    protected HudElement element;

    public HudModule(String name, Category category, int defaultX, int defaultY) {
        super(name, category);
        this.element = new HudElement(defaultX, defaultY);
    }

    public abstract void renderHud(DrawContext ctx, float tickDelta);
    public HudElement getElement() { return element; }
}
