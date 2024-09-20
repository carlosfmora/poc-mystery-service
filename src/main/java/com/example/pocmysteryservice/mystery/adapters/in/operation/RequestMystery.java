package com.example.pocmysteryservice.mystery.adapters.in.operation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class RequestMystery {
    @Positive
    private double value;
    @NotNull
    private UUID id;

    public UUID getId() {
        return this.id;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
