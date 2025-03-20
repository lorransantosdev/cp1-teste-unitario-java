package org.example.service;

import org.example.model.ValueFormatterModel;
import org.example.repository.ValueFormatterRepository;

import java.util.List;
import java.util.Locale;

public class ValueFormatterService {
    private final ValueFormatterRepository repository = new ValueFormatterRepository();

    public void processFormatting() {

        int decimalPlaces = repository.getDecimalPlacesFromUser();
        Locale typeSymbols = repository.getShowTypeSymbols();
        String separatorType = repository.getSeparatorTypeFromUser();

        ValueFormatterModel model = new ValueFormatterModel(decimalPlaces, separatorType, typeSymbols);

        List<Double> decimalValues = repository.getDecimalValuesFromUser(model.getDecimalPlaces());
        repository.formatAndPrintValues(decimalValues, model.getSeparatorType(), model.getTypeSymbols());
    }
}