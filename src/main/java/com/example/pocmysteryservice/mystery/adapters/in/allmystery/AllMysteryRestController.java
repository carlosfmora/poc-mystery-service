package com.example.pocmysteryservice.mystery.adapters.in.allmystery;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.ResponsePageList;
import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.AllMysteryUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllMysteryRestController {
    private final AllMysteryUseCase useCase;

    public AllMysteryRestController(AllMysteryUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("mystery")
    ResponsePageList<Mystery> allMystery() throws InternalFailureException, BusinessRuleViolationException {
        return this.useCase.allMystery(null);
    }

}
