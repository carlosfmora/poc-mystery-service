package com.example.pocmysteryservice;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.AllMysteryUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocMysteryServiceApplicationTests {
    @Autowired
    AllMysteryUseCase useCase;

    @Test
    void contextLoads() throws InternalFailureException, BusinessRuleViolationException {
        System.out.println(useCase.allMystery(null));
    }

}
