package com.dn.handson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// SLF4J Exercise 1: logging at error / warn / info levels.
public class LoggingDemo {
    private static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public void run() {
        log.info("Application started");
        log.warn("Low disk space warning");
        try {
            throw new IllegalStateException("simulated failure");
        } catch (Exception e) {
            log.error("Operation failed: {}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoggingDemo().run();
    }
}
