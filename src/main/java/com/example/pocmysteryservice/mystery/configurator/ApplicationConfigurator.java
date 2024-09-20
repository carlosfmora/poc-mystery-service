package com.example.pocmysteryservice.mystery.configurator;

import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.AllMysteryUseCase;
import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.impl.AllMysteryUseCaseImpl;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationUseCase;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.impl.DeductFromAccountUseCaseImpl;
import com.example.pocmysteryservice.mystery.application.ports.out.AllDataPort;
import com.example.pocmysteryservice.mystery.application.ports.out.GetAccountPort;
import com.example.pocmysteryservice.mystery.application.ports.out.UpdateBalanceAccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurator {

    @Bean
    public AllMysteryUseCase instanceAllMysteryUseCase(AllDataPort allDataPort) {
        return new AllMysteryUseCaseImpl(allDataPort);
    }

    @Bean
    public MysteryOperationUseCase instanceMysteryOperation(GetAccountPort getAccountPort, UpdateBalanceAccountPort updateBalancePort) {
        return new DeductFromAccountUseCaseImpl(getAccountPort, updateBalancePort);
    }
}
