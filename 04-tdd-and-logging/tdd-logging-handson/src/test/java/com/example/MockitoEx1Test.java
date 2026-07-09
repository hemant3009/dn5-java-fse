package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoEx1Test {

    @Test
    void testMock() {

        UserRepository repo = mock(UserRepository.class);

        when(repo.getName()).thenReturn("Hemant");

        UserService service = new UserService(repo);

        assertEquals("Hemant", service.getUser());

    }

}