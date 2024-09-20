package com.example.pocmysteryservice.mystery.application;

import java.util.Date;
import java.util.UUID;

public class Account implements Mystery {
    private final UUID id;
    private String type;
    private double balance;
    private final Date creationDate;

    private Account(UUID id, String type, double balance, Date creationDate) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public static Account from(UUID id, String type, double balance, Date creationDate) {
        return new Account(id, type, balance, creationDate);
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.type;
    }

    @Override
    public double getValue() {
        return this.balance;
    }

    @Override
    public Date getDate() {
        return this.creationDate;
    }

    public void deduct(double amount) throws InsufficientFundsException, CreditLimitException {
        double newBalance = this.balance - amount;
        if ("AHORROS".equals(this.type) && newBalance < 0) {
            throw new InsufficientFundsException(this);
        }
        double creditLimit = -1000000;
        if (newBalance < creditLimit) {
            throw new CreditLimitException(creditLimit);
        }
        this.balance = newBalance;

    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", balance=" + balance +
            ", creationDate=" + creationDate +
            '}';
    }
}
