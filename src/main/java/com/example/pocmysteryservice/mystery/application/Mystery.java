package com.example.pocmysteryservice.mystery.application;

import java.util.Date;
import java.util.UUID;

public interface Mystery {
    UUID getId();

    String getName();

    double getValue();

    Date getDate();
}
