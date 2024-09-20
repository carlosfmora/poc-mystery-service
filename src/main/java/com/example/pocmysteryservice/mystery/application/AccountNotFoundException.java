package com.example.pocmysteryservice.mystery.application;

import java.util.UUID;

public class AccountNotFoundException extends BusinessRuleViolationException {
    public AccountNotFoundException(UUID accountId) {
        super(new ErrorMessage("Account not found: " + accountId, null));
    }
}
