package org.example.model;

import org.example.exception.InvalidInputException;

import java.util.Locale;

public class ValueFormatterModel {
    private int decimalPlaces;
    private String separatorType;
    private Locale typeSymbols;

    public ValueFormatterModel() { }

    public ValueFormatterModel(int decimalPlaces, String separatorType, Locale typeSymbols) {
        if (decimalPlaces <= 0) {
            throw new InvalidInputException("Decimal places must be greater than zero.");
        }
        if (!separatorType.equals(".") && !separatorType.equals(",")) {
            throw new InvalidInputException("Separator type must be '.' or ','.");
        }
        this.decimalPlaces = decimalPlaces;
        this.separatorType = separatorType;
        this.typeSymbols = typeSymbols;
    }

    public int getDecimalPlaces() { return decimalPlaces; }
    public String getSeparatorType() { return separatorType; }
    public Locale getTypeSymbols() { return typeSymbols; }
}