package org.example.service;

import org.example.exception.InvalidInputException;
import org.example.model.ValueFormatterModel;
import org.example.repository.impl.ValueFormatterImpl;

import java.util.List;
import java.util.Locale;

public class ValueFormatterService {
    private final ValueFormatterImpl repository;

    public ValueFormatterService(ValueFormatterImpl repository) {
        this.repository = repository;
    }

    public int startProcessFormatting() {
        try {
            return process();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }

    public int process() {

        int decimalPlaces = validPlaces();
        Locale typeSymbols = repository.getShowTypeSymbols();
        char separatorType = validShowTypes();

        ValueFormatterModel model = new ValueFormatterModel(decimalPlaces, separatorType, typeSymbols);

        List<Double> decimalValues = repository.getDecimalValuesFromUser(model.getDecimalPlaces());
        repository.formatAndPrintValues(decimalValues, model.getSeparatorType(), model.getTypeSymbols());

        return decimalValues.size();
    }

    public int validPlaces() {
        int decimalPlaces = repository.getDecimalPlacesFromUser();
        if (decimalPlaces <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        return decimalPlaces;
    }

    public char validShowTypes() {
        char separatorType = repository.getSeparatorTypeFromUser();
        if (separatorType != '.' && separatorType != ',' ) {
            throw new InvalidInputException("Separador inválido! Use '.' ou ','.");
        }
        return separatorType;
    }
    
}
