package com.dn.handson;

// Dependency to be mocked in Mockito exercises.
public interface AccountRepository {
    double getBalance(String accountId);
    void save(String accountId, double amount);
}
