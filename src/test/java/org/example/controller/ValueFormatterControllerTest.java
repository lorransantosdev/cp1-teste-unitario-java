package org.example.controller;

import org.example.exception.InvalidFormatException;
import org.example.service.ValueFormatterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ValueFormatterControllerTest {

    @InjectMocks
    private ValueFormatterController controller;

    @Mock
    private ValueFormatterService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartFormattingProcessShouldSucessfully() {
        when(service.startProcessFormatting()).thenReturn(5);

        assertDoesNotThrow(() -> controller.startFormattingProcess());

    }

    @Test
    void testStartFormattingProcessException() {
        when(service.startProcessFormatting()).thenReturn(0);

        Exception exception = assertThrows(InvalidFormatException.class, () -> controller.startFormattingProcess());
        assertEquals("Nenhum valor foi formatado", exception.getMessage());

    }

}