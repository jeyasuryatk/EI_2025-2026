package com.satellite.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private String timestamp() {
        return "[" + LocalDateTime.now().format(formatter) + "]";
    }

    public void info(String message) {
        System.out.println(timestamp() + " [INFO] " + message);
    }

    public void warn(String message) {
        System.out.println(timestamp() + " [WARN] " + message);
    }

    public void error(String message) {
        System.err.println(timestamp() + " [ERROR] " + message);
    }
}
