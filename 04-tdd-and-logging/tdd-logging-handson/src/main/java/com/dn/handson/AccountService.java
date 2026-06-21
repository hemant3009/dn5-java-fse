package com.dn.handson;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public double balanceOf(String accountId) {
        return repository.getBalance(accountId);
    }

    public void deposit(String accountId, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive");
        repository.save(accountId, amount);
    }
}
