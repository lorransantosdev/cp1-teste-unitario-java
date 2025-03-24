package org.example.exception;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidInputExceptionTest {

    @Test
    void testInstance() {
        InvalidInputException exception = new InvalidInputException("Valor errado");
        assertEquals("Valor errado", exception.getMessage());
    }

}