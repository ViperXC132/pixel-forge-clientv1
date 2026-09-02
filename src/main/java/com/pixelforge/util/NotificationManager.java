package com.pixelforge.util;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    public static final List<Notification> notifications = new ArrayList<>();

    public static void push(String title, String message) {
        notifications.add(new Notification(title, message, System.currentTimeMillis()));
    }

    public static class Notification {
        public final String title, message;
        public final long time;
        public Notification(String title, String message, long time) {
            this.title = title; this.message = message; this.time = time;
        }
    }
}
