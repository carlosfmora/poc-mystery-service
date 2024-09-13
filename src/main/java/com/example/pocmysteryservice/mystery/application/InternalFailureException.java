package com.example.pocmysteryservice.mystery.application;

public class InternalFailureException extends Exception implements IErrorMessage{
    private final ErrorMessage errorMessage;

    public InternalFailureException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
