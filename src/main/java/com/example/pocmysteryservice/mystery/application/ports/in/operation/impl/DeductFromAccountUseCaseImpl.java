package com.example.pocmysteryservice.mystery.application.ports.in.operation.impl;

import com.example.pocmysteryservice.mystery.application.*;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationCommand;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationUseCase;
import com.example.pocmysteryservice.mystery.application.ports.out.GetAccountPort;
import com.example.pocmysteryservice.mystery.application.ports.out.UpdateBalanceAccountPort;

public class DeductFromAccountUseCaseImpl implements MysteryOperationUseCase {

    private final GetAccountPort getAccountPort;
    private final UpdateBalanceAccountPort updateBalancePort;

    public DeductFromAccountUseCaseImpl(GetAccountPort getAccountPort, UpdateBalanceAccountPort updateBalancePort) {
        this.getAccountPort = getAccountPort;
        this.updateBalancePort = updateBalancePort;
    }

    @Override
    public Mystery mysteryOperation(MysteryOperationCommand command) throws InternalFailureException, BusinessRuleViolationException {

        Account account = (Account) this.getAccountPort
            .getAccount(command.getAccountId())
            .orElseThrow(() -> new AccountNotFoundException(command.getAccountId()));

        account.deduct(command.getAmount());
        this.updateBalancePort.updateBalance(command.getAccountId(), account.getValue());
        return account;
    }

}
