package com.example.pocmysteryservice.mystery.application.ports.in.operation;

import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;

import java.util.UUID;

public class MysteryOperationCommand {
    private final UUID uuid;
    private final double value;

    private MysteryOperationCommand(UUID uuid, double value) {
        this.uuid = uuid;
        this.value = value;
        this.execute();
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

    /**
     * @throws UncheckedInputDataException
     */
    private void execute() {

    }
}
