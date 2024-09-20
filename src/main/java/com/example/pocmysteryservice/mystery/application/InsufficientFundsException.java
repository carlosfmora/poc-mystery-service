package com.example.pocmysteryservice.mystery.application;

public class InsufficientFundsException extends BusinessRuleViolationException {
    public InsufficientFundsException(Account account) {
        super(new ErrorMessage("Insufficient Funds: " + account.getValue(), null));
    }
}
