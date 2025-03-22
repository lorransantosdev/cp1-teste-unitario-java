package org.example.repository.impl;

import org.example.exception.InvalidInputException;
import org.example.repository.ValueFormatterRepository;
import org.example.repository.ValueFormatterRepository.Decimal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.Scanner;

public class ValueFormatterImpl implements ValueFormatterRepository, ValueFormatterRepository.Decimal {
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public int getDecimalPlacesFromUser() {
        System.out.print("Enter the number of decimal places: ");
        if (!scanner.hasNextInt()) {
            throw new InvalidInputException("Invalid input! Please enter a valid number.");
        }
        return scanner.nextInt();
    }


    @Override
    public Locale getShowTypeSymbols() {
        System.out.println("\n=== Escolha um Simbolo ===");
        System.out.println("""
                1 - ENGLISH
                2 - FRENCH
                3 - GERMAN
                4 - ITALIAN
                5 - JAPANESE
                6 - KOREAN
                7 - CHINESE
                8 - SIMPLIFIED_CHINESE
                9 - TRADITIONAL_CHINESE
                10 - FRANCE
                11 - GERMANY
                12 - ITALY
                13 - JAPAN
                14 - KOREA
                15 - UK
                16 - US
                17 - CANADA
                18 - CANADA_FRENCH
                19 - ROOT
                """);

        System.out.print("Digite um número referente ao símbolo escolhido: ");
        int symbolNumber = scanner.nextInt();
        return switch (symbolNumber) {
            case 1 -> Locale.ENGLISH;
            case 2 -> Locale.FRENCH;
            case 3 -> Locale.GERMAN;
            case 4 -> Locale.ITALIAN;
            case 5 -> Locale.JAPANESE;
            case 6 -> Locale.KOREAN;
            case 7 -> Locale.CHINESE;
            case 8 -> Locale.SIMPLIFIED_CHINESE;
            case 9 -> Locale.TRADITIONAL_CHINESE;
            case 10 -> Locale.FRANCE;
            case 11 -> Locale.GERMANY;
            case 12 -> Locale.ITALY;
            case 13 -> Locale.JAPAN;
            case 14 -> Locale.KOREA;
            case 15 -> Locale.UK;
            case 16 -> Locale.US;
            case 17 -> Locale.CANADA;
            case 18 -> Locale.CANADA_FRENCH;
            case 19 -> Locale.ROOT;
            default -> throw new InvalidInputException("Tipo de simbolo inválido.");
        };
    }


    @Override
    public char getSeparatorTypeFromUser() {
        System.out.print("Enter the separator type ('.' or ','): ");
        return scanner.next().charAt(0);
    }


    @Override
    public List<Double> getDecimalValuesFromUser(int amount) {
        List<Double> decimalValues = new ArrayList<>();
        double decimalValue;
        for (int i = 1; i <= amount; i++) {
            System.out.print(i + "º number: ");
            if (!scanner.hasNextDouble()) {
                throw new InvalidInputException("Número inválido! Por favor, insira um número decimal.");
            }
            decimalValue = scanner.nextDouble();
            decimalValues.add(decimalValue);
        }
        return decimalValues;
    }


    @Override
    public void formatAndPrintValues(List<Double> values, char separatorType, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setDecimalSeparator(separatorType);
        DecimalFormat formatter = new DecimalFormat("#" + separatorType + "##", symbols);

        for (double value : values) {
            System.out.println("Valor Formatado: " + formatter.format(value));
        }
    }
}
