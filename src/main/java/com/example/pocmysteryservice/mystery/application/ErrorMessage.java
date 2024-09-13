package com.example.pocmysteryservice.mystery.application;

import java.util.List;

public record ErrorMessage(String message,
                           List<ErrorDetail> details) {

    public String getMessage() {
        return message;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }
}
