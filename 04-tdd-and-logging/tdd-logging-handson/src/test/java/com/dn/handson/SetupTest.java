package com.dn.handson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// JUnit Exercise 1: Setting Up JUnit — a trivial passing test confirming JUnit 5 works.
class SetupTest {
    @Test
    void junitIsConfigured() {
        assertTrue(true, "JUnit 5 is on the classpath and running");
    }
}
