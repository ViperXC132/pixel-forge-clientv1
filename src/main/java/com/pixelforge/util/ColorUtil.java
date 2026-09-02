package com.pixelforge.util;

public class ColorUtil {
    public static int rgba(int r, int g, int b, int a) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static int rgb(int r, int g, int b) {
        return rgba(r, g, b, 255);
    }

    public static int withAlpha(int color, int alpha) {
        return (color & 0x00FFFFFF) | (alpha << 24);
    }

    public static int WHITE = rgb(255, 255, 255);
    public static int BLACK = rgb(0, 0, 0);
    public static int DARK_BG = rgba(10, 10, 20, 180);
    public static int ACCENT = rgb(108, 99, 255);
}
