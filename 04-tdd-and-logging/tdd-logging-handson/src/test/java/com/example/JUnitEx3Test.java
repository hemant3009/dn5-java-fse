package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JUnitEx3Test {
  Calculator c = new Calculator();
  
  @Test
  void testAssertions(){
    
    assertEquals(5, c.add(2,3));
    
    assertTrue(10 > 5);
    
    assertFalse(5 > 10);
    
    assertNotNull(c);

    assertThrows(ArithmeticException.class, () -> {
        c.divide(10, 0);
    });
  }
}
