package com.example.pocmysteryservice.mystery.application;

public class BusinessRuleViolationException extends Exception implements IErrorMessage{

    private final ErrorMessage errorMessage;

    public BusinessRuleViolationException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
