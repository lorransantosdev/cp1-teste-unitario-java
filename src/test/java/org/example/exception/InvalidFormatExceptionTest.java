package org.example.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidFormatExceptionTest {

    @Test
    void testIntance() {
        InvalidFormatException exception = new InvalidFormatException("Erro ao formatar");
        assertEquals("Erro ao formatar", exception.getMessage());
    }

}