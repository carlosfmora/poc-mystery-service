package com.example.pocmysteryservice.mystery.application;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;

public record ErrorDetail(String path, String message) {

    public static ErrorDetail from(ConstraintViolation<?> violation) {
        return new ErrorDetail(
//            getPathWithSlash(violation.getPropertyPath()),
            violation.getPropertyPath().toString(),
            violation.getMessage()
        );
    }

    // TODO: 13/09/24 por defecto el path es con punto, esto aplica segun la app,
    //  pero creo que es mejor con punto
    private String getPathWithSlash(Path propertyPath) {
        return propertyPath.toString().replaceAll("\\.", "/");
    }

    // TODO: 13/09/24 quitar, es un record
    public String getPath() {
        return path;
    }

    // TODO: 13/09/24 quitar, es un record
    public String getMessage() {
        return message;
    }
}
