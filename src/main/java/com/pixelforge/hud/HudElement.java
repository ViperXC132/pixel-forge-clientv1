package com.pixelforge.hud;

public class HudElement {
    private int x, y;
    private float scale;
    private boolean dragging;
    private int dragOffsetX, dragOffsetY;

    public HudElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.scale = 1.0f;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public float getScale() { return scale; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setScale(float scale) { this.scale = scale; }
    public boolean isDragging() { return dragging; }
    public void setDragging(boolean dragging) { this.dragging = dragging; }
    public int getDragOffsetX() { return dragOffsetX; }
    public int getDragOffsetY() { return dragOffsetY; }
    public void setDragOffset(int x, int y) { dragOffsetX = x; dragOffsetY = y; }
}
