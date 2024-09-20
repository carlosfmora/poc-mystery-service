package com.example.pocmysteryservice.mystery.application.ports.in.operation;

import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class MysteryOperationCommand {

    @NotNull
    private final UUID uuid;
    @Positive
    private final double value;

    private MysteryOperationCommand(UUID uuid, double value) {
        this.uuid = uuid;
        this.value = value;
        UncheckedInputDataException.ensureInputData(this);
    }

    /**
     * @param uuid
     * @param value
     * @return
     * @throws UncheckedInputDataException
     */
    public static MysteryOperationCommand from(UUID uuid, double value) throws UncheckedInputDataException {
        return new MysteryOperationCommand(uuid, value);
    }

    public UUID getAccountId() {
        return this.uuid;
    }

    public double getAmount() {
        return this.value;
    }
}
