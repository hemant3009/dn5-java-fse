package com.dn.handson;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Mockito Exercise 1: Mocking & Stubbing. Exercise 2: Verifying Interactions.
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountRepository repository;

    @Test
    void stubbingReturnsMockedBalance() {
        when(repository.getBalance("A1")).thenReturn(500.0);   // stub
        AccountService service = new AccountService(repository);
        assertEquals(500.0, service.balanceOf("A1"));
    }

    @Test
    void verifyRepositorySaveWasCalled() {
        AccountService service = new AccountService(repository);
        service.deposit("A1", 200.0);
        verify(repository, times(1)).save("A1", 200.0);   // interaction verification
    }
}
