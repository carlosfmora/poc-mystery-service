package com.example.pocmysteryservice.mystery.application;

import jakarta.validation.ConstraintViolation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public record ErrorMessage(String message,
                           List<ErrorDetail> details) {

    public static ErrorMessage from(Set<? extends ConstraintViolation<?>> constrains) {
        List<ErrorDetail> data = new LinkedList<>();
        constrains.stream()
            .map(ErrorDetail::from)
            .forEach(data::add);
        return new ErrorMessage("Invalid Input Data", data);
    }

    public String getMessage() {
        return message;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }
}
