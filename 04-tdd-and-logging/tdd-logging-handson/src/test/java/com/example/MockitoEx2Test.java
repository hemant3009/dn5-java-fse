package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoEx2Test {

    @Test
    void testVerify() {

        UserRepository repo = mock(UserRepository.class);

        UserService service = new UserService(repo);

        service.addUser("Hemant");

        verify(repo).save("Hemant");

    }

}