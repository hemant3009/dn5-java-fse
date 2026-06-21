package com.dn.handson;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// JUnit Exercise 4: AAA pattern, fixtures, setup/teardown.
class AaaFixturesTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void addsTwoNumbers() {
        // Arrange
        int a = 7, b = 8;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(15, result);
    }
}
