package com.example.pocmysteryservice.mystery.application.ports.in.operation;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;

public interface MysteryOperationUseCase {
    /**
     * @return {@link Mystery}
     * @throws UncheckedInputDataException
     * @throws BusinessRuleViolationException
     */
    Mystery mysteryOperation(MysteryOperationCommand command) throws InternalFailureException, BusinessRuleViolationException;
}
