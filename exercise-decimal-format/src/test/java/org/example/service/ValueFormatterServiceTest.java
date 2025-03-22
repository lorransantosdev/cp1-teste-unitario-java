package org.example.service;

import org.example.exception.InvalidInputException;
import org.example.repository.impl.ValueFormatterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValueFormatterServiceTest {

    @InjectMocks
    private ValueFormatterService service;

    @Mock
    private ValueFormatterImpl repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testStartProcessFormattingShouldReturnValidAmountWhenNoException() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(1);
        when(repository.getShowTypeSymbols()).thenReturn(Locale.US);
        when(repository.getSeparatorTypeFromUser()).thenReturn('.');
        when(repository.getDecimalValuesFromUser(anyInt())).thenReturn(List.of(10.5));

        assertEquals(1, service.startProcessFormatting());
    }

    @Test
    void testStartProcessFormattingShouldReturnZeroWhenExceptionIsThrown() {
        when(repository.getDecimalPlacesFromUser()).thenReturn(0);

        assertEquals(0, service.startProcessFormatting());
    }

    @Test
    void testProcessShouldReturnOneDecimalFormatWhenIsOk() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(1);
        when(repository.getShowTypeSymbols()).thenReturn(Locale.US);
        when(repository.getSeparatorTypeFromUser()).thenReturn('.');
        when(repository.getDecimalValuesFromUser(anyInt())).thenReturn(List.of(10.5));

        assertEquals(1, service.process());
    }

    @Test
    void testProcessShouldReturnTwoDecimalFormatWhenIsOk() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(2);
        when(repository.getShowTypeSymbols()).thenReturn(Locale.US);
        when(repository.getSeparatorTypeFromUser()).thenReturn(',');
        when(repository.getDecimalValuesFromUser(anyInt())).thenReturn(List.of(10.5, 100.58));

        assertEquals(2, service.process());
    }

    @Test
    void testvalidPlacesShouldSucessfullyWhenReturnOne() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(1);
        assertEquals(1, service.validPlaces());
    }

    @Test
    void testvalidPlacesShouldSucessfullyWhenReturnTwo() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(2);
        assertEquals(2, service.validPlaces());
    }

    @Test
    void testvalidPlacesShouldThrowNewExceptionWhenIsZero() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getDecimalPlacesFromUser()).thenReturn(0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validPlaces();
            });
        assertEquals("A quantidade deve ser maior que zero", exception.getMessage());
    }

    @Test
    void testvalidShowTypesShouldSucessfullyWhenReturnChar() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getSeparatorTypeFromUser()).thenReturn(',');
        assertEquals(',', service.validShowTypes());
    }

    @Test
    void testvalidShowTypesShouldSucessfullyWhenReturnChar1() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getSeparatorTypeFromUser()).thenReturn('.');
        assertEquals('.', service.validShowTypes());
    }

    @Test
    void testvalidShowTypesShouldThrowNewExceptionWhenCharNotEquals() {
        Scanner scannerMock = mock(Scanner.class);

        when(repository.getSeparatorTypeFromUser()).thenReturn('a');
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            service.validShowTypes();
        });
        assertEquals("Separador inválido! Use '.' ou ','.", exception.getMessage());
    }

}