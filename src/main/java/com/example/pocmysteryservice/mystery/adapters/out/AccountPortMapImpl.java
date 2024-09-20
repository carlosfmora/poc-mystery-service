package com.example.pocmysteryservice.mystery.adapters.out;

import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.ports.out.AllDataPort;
import com.example.pocmysteryservice.mystery.application.ports.out.GetAccountPort;
import com.example.pocmysteryservice.mystery.application.ports.out.PutAccountPort;
import com.example.pocmysteryservice.mystery.application.ports.out.UpdateBalanceAccountPort;

import java.util.*;

public class AccountPortMapImpl implements GetAccountPort, PutAccountPort, AllDataPort, UpdateBalanceAccountPort {
    private final HashMap<UUID, Mystery> map;

    public AccountPortMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public Optional<Mystery> getAccount(UUID accountId) {
        return Optional.ofNullable(map.get(accountId));
    }

    @Override
    public void putAccount(Mystery account) {
        this.map.put(account.getId(), account);
    }

    @Override
    public String toString() {
        return "AccountPortMapImpl{" +
            "map=" + map.values() +
            '}';
    }

    @Override
    public List<Mystery> allData() {
        return map.values().stream().toList();
    }

    @Override
    public void updateBalance(UUID accountId, double value) {
        Mystery mystery = this.map.get(accountId);

        this.map.put(accountId, new Mystery() {
            @Override
            public UUID getId() {
                return accountId;
            }

            @Override
            public String getName() {
                return mystery.getName();
            }

            @Override
            public double getValue() {
                return value;
            }

            @Override
            public Date getDate() {
                return mystery.getDate();
            }
        });
    }
}
