package com.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitEx4Test {

    Calculator c;

    @BeforeEach
    void setup() {

        c = new Calculator();

    }

    @AfterEach
    void teardown() {

        c = null;

    }

    @Test
    void testAdd() {

        // Arrange
        int a = 5;
        int b = 4;

        // Act
        int ans = c.add(a,b);

        // Assert
        assertEquals(9, ans);

    }

}