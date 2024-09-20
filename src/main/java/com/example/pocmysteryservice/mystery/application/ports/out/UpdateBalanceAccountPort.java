package com.example.pocmysteryservice.mystery.application.ports.out;

import java.util.UUID;

public interface UpdateBalanceAccountPort {
    void updateBalance(UUID accountId, double value);
}
