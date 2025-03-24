package org.example.model;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class ValueFormatterModelTest {

    @Test
    void testDefaultConstructor() {
        ValueFormatterModel model = new ValueFormatterModel();
        assertEquals(0, model.getDecimalPlaces());
        assertEquals('\0', model.getSeparatorType()); // Valor padrão de char é '\0'
        assertNull(model.getTypeSymbols());
    }

    @Test
    void testParameterizedConstructor() {
        int decimalPlaces = 2;
        char separatorType = ',';
        Locale typeSymbols = Locale.US;

        ValueFormatterModel model = new ValueFormatterModel(decimalPlaces, separatorType, typeSymbols);

        assertEquals(decimalPlaces, model.getDecimalPlaces());
        assertEquals(separatorType, model.getSeparatorType());
        assertEquals(typeSymbols, model.getTypeSymbols());
    }
}
