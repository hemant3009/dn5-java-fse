package com.dn.handson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// JUnit Exercise 3: Assertions in JUnit.
class AssertionsTest {
    private final Calculator calc = new Calculator();

    @Test
    void assertEqualsExample() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void assertTrueExample() {
        assertTrue(calc.add(2, 2) == 4);
    }

    @Test
    void assertThrowsExample() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }
}
