package com.example.pocmysteryservice.mystery.application.ports.out;

import com.example.pocmysteryservice.mystery.application.Mystery;

import java.util.Optional;
import java.util.UUID;

public interface GetAccountPort {
    Optional<Mystery> getAccount(UUID accountId);
}
