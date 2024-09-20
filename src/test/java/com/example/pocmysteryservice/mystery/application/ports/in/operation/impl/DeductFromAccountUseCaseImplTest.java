package com.example.pocmysteryservice.mystery.application.ports.in.operation.impl;

import com.example.pocmysteryservice.mystery.adapters.out.AccountPortMapImpl;
import com.example.pocmysteryservice.mystery.application.*;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationCommand;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

class DeductFromAccountUseCaseImplTest {

    @Test
    void shouldOKByCredito() {
        var accountPort = new AccountPortMapImpl();
        UUID uuid = UUID.randomUUID();
        Account accountTest = Account.from(uuid, "CREDITO", 200, new Date());
        accountPort.putAccount(accountTest);
        MysteryOperationUseCase useCase = new DeductFromAccountUseCaseImpl(accountPort, accountPort);
        MysteryOperationCommand command = MysteryOperationCommand.from(uuid, 300);
        try {
            Mystery response = useCase.mysteryOperation(command);
            Assertions.assertEquals(-100, response.getValue());
            Assertions.assertEquals(uuid, response.getId());
        } catch (InternalFailureException e) {
            System.out.println(e.getErrorMessage());
            fail();
            e.printStackTrace();
        } catch (BusinessRuleViolationException e) {
            System.out.println(e.getErrorMessage());
            fail();
        }
        System.out.println(accountPort);
    }

    @Test
    void shouldOKByAhorros() {
        var accountPort = new AccountPortMapImpl();
        UUID uuid = UUID.randomUUID();
        Account accountTest = Account.from(uuid, "AHORROS", 200, new Date());
        accountPort.putAccount(accountTest);
        MysteryOperationUseCase useCase = new DeductFromAccountUseCaseImpl(accountPort, accountPort);
        MysteryOperationCommand command = MysteryOperationCommand.from(uuid, 50);
        try {
            Mystery response = useCase.mysteryOperation(command);
            Assertions.assertEquals(150, response.getValue());
            Assertions.assertEquals(uuid, response.getId());
        } catch (InternalFailureException e) {
            System.out.println(e.getErrorMessage());
            fail();
            e.printStackTrace();
        } catch (BusinessRuleViolationException e) {
            System.out.println(e.getErrorMessage());
            fail();
        }
        System.out.println(accountPort);
    }

    @Test
    void shouldThrowBusinessExceptionWithInsufficientFunds() {
        var accountPort = new AccountPortMapImpl();
        UUID uuid = UUID.randomUUID();
        Account accountTest = Account.from(uuid, "AHORROS", 200, new Date());
        accountPort.putAccount(accountTest);
        MysteryOperationUseCase useCase = new DeductFromAccountUseCaseImpl(accountPort, accountPort);
        MysteryOperationCommand command = MysteryOperationCommand.from(uuid, 300);
        try {
            Mystery response = useCase.mysteryOperation(command);
            fail();
        } catch (InternalFailureException e) {
            System.out.println(e.getErrorMessage());
            fail();
            e.printStackTrace();
        } catch (BusinessRuleViolationException e) {
            System.out.println(e.getErrorMessage());
            Assertions.assertTrue(e instanceof InsufficientFundsException);
        }
        System.out.println(accountPort);
    }

    @Test
    void shouldThrowBusinessExceptionWithAccountNotFound() {
        var accountPort = new AccountPortMapImpl();
        MysteryOperationUseCase useCase = new DeductFromAccountUseCaseImpl(accountPort, accountPort);
        MysteryOperationCommand command = MysteryOperationCommand.from(UUID.randomUUID(), 300);
        try {
            Mystery response = useCase.mysteryOperation(command);
            fail();
        } catch (InternalFailureException e) {
            System.out.println(e.getErrorMessage());
            e.printStackTrace();
            fail();
        } catch (BusinessRuleViolationException e) {
            System.out.println(e.getErrorMessage());
            Assertions.assertTrue(e instanceof AccountNotFoundException);
        }
        System.out.println(accountPort);
    }
}
