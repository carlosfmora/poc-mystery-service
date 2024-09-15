package com.example.pocmysteryservice.mystery.application;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class UncheckedInputDataException extends RuntimeException implements IErrorMessage {

    private final static Validator validator =
        buildDefaultValidatorFactory().getValidator();

    private final ErrorMessage errorMessage;

    public UncheckedInputDataException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    private <T> UncheckedInputDataException(Set<ConstraintViolation<T>> violations) {
        this.errorMessage = ErrorMessage.from(violations);
    }

    public static <T> void ensureInputData(T subject) {
        Set<ConstraintViolation<T>> violations = validator.validate(subject);
        if (!violations.isEmpty()) {
            throw new UncheckedInputDataException(violations);
        }
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
