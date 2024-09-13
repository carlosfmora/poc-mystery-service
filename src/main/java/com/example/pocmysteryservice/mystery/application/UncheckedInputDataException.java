package com.example.pocmysteryservice.mystery.application;

public class UncheckedInputDataException extends RuntimeException implements IErrorMessage{
    private final ErrorMessage errorMessage;

    public UncheckedInputDataException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
