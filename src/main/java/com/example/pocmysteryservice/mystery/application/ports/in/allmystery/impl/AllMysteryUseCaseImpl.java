package com.example.pocmysteryservice.mystery.application.ports.in.allmystery.impl;

import com.example.pocmysteryservice.mystery.application.BusinessRuleViolationException;
import com.example.pocmysteryservice.mystery.application.InternalFailureException;
import com.example.pocmysteryservice.mystery.application.Mystery;
import com.example.pocmysteryservice.mystery.application.ResponsePageList;
import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.AllMysteryQuery;
import com.example.pocmysteryservice.mystery.application.ports.in.allmystery.AllMysteryUseCase;
import com.example.pocmysteryservice.mystery.application.ports.out.AllDataPort;

import java.util.List;

public class AllMysteryUseCaseImpl implements AllMysteryUseCase {
    private final AllDataPort allDataPort;

    public AllMysteryUseCaseImpl(AllDataPort allDataPort) {
        this.allDataPort = allDataPort;
    }

    @Override
    public ResponsePageList<Mystery> allMystery(AllMysteryQuery query) throws InternalFailureException, BusinessRuleViolationException {
        List<Mystery> data = this.allDataPort.allData();
        return new ResponsePageList<>(1, data.size(), data);
    }
}
