package com.example.pocmysteryservice.mystery.application;

public record ErrorDetail(String path, String message) {

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
