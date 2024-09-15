package com.example.pocmysteryservice.mystery.application.ports.in.operation;

import com.example.pocmysteryservice.mystery.application.ErrorDetail;
import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class MysteryOperationCommandTest {

    @Test
    void creation() {
        try {

            MysteryOperationCommand mysteryOperationCommand = MysteryOperationCommand.from(null, 0);
            fail();
        }catch (UncheckedInputDataException exception){
            for (ErrorDetail detail :
                exception.getErrorMessage().getDetails()) {
                System.out.println("---");
                System.out.println("Path: " + detail.getPath());
                System.out.println("Message: " + detail.getMessage());
            }
        }
    }
}
