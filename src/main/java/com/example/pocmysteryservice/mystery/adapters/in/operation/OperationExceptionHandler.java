package com.example.pocmysteryservice.mystery.adapters.in.operation;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.ErrorMessage;
import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = OperationRestController.class)
public class OperationExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("El cuerpo de la solicitud no es válido", null));
    }

    @ExceptionHandler(UncheckedInputDataException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(UncheckedInputDataException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorMessage());
    }

    @ExceptionHandler(BusinessRuleViolationException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(BusinessRuleViolationException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getErrorMessage());
    }

}
