package com.example.pocmysteryservice.mystery.adapters.in.operation;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationCommand;
import com.example.pocmysteryservice.mystery.application.ports.in.operation.MysteryOperationUseCase;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestController {
    private final MysteryOperationUseCase useCase;

    public OperationRestController(MysteryOperationUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("mystery")
    Mystery operation(@RequestBody @Validated RequestMystery requestMystery) throws InternalFailureException, BusinessRuleViolationException {
        return this.useCase.mysteryOperation(MysteryOperationCommand.from(requestMystery.getId(), requestMystery.getValue()));
    }
}
