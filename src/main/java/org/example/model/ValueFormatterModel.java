package org.example.model;

import java.util.Locale;

public class ValueFormatterModel {
    private int decimalPlaces;
    private char separatorType;
    private Locale typeSymbols;

    public ValueFormatterModel() { }

    public ValueFormatterModel(int decimalPlaces, char separatorType, Locale typeSymbols) {
        this.decimalPlaces = decimalPlaces;
        this.separatorType = separatorType;
        this.typeSymbols = typeSymbols;
    }

    public int getDecimalPlaces() { return decimalPlaces; }
    public char getSeparatorType() { return separatorType; }
    public Locale getTypeSymbols() { return typeSymbols; }

}