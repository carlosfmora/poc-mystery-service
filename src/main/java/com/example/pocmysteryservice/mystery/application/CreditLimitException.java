package com.example.pocmysteryservice.mystery.application;

public class CreditLimitException extends BusinessRuleViolationException {
    public CreditLimitException(double creditLimit) {
        super(new ErrorMessage("Credit limit would be exceeded: " + creditLimit, null));
    }
}
