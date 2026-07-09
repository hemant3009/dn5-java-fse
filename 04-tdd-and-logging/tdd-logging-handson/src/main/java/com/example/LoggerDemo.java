package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {
  Logger logger = LoggerFactory.getLogger(LoggerDemo.class);
  
  public void showLogs() {
    logger.error("Error Message");
    logger.warn("Warning Message");
    logger.info("Information Message");
  }
}
