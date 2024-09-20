package com.example.pocmysteryservice.mystery.configurator;

import com.example.pocmysteryservice.mystery.adapters.out.AccountPortMapImpl;
import com.example.pocmysteryservice.mystery.application.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.UUID;

@Configuration
public class AdapterOutputConfigurator {
    @Bean
    public AccountPortMapImpl getMapImpl() {
        AccountPortMapImpl mapPort = new AccountPortMapImpl();
        Account creditAccount = Account.from(UUID.randomUUID(), "CREDITO", 350000, new Date());
        mapPort.putAccount(creditAccount);
        Account ahorrosAccount = Account.from(UUID.randomUUID(), "AHORROS", 350000, new Date());
        mapPort.putAccount(ahorrosAccount);
        return mapPort;
    }


}
