package com.example.pocmysteryservice.mystery.adapters.in.operation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

public class RequestMystery {
    private double value;
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
