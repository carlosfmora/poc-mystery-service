package com.example.pocmysteryservice.mystery.application.ports.in.allmystery;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.ResponsePageList;

public interface AllMysteryUseCase {

    /**
     *
     * @param
     * @throws InternalFailureException
     * @throws BusinessRuleViolationException
     */
    ResponsePageList<Mystery> allMystery(AllMysteryQuery query)  throws InternalFailureException, BusinessRuleViolationException;
}
