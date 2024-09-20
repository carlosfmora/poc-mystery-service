package com.example.pocmysteryservice.mystery.application.ports.in.operation;

import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MysteryOperationCommandTest {

    @Test
    void creation() {
        UncheckedInputDataException exception = assertThrows(UncheckedInputDataException.class, () -> {
            MysteryOperationCommand mysteryOperationCommand = MysteryOperationCommand.from(null, 0);
        });
        assertNotNull(exception);
        assertEquals(2, exception.getErrorMessage().getDetails().size());
        System.out.println(exception.getErrorMessage());
//        for (ErrorDetail detail :
//            exception.getErrorMessage().getDetails()) {
//            System.out.println("---");
//            System.out.println("Path: " + detail.getPath());
//            System.out.println("Message: " + detail.getMessage());
//        }
    }
}
