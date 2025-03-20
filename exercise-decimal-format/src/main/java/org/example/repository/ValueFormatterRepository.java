package org.example.repository;

import org.example.exception.InvalidInputException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.Scanner;

public class ValueFormatterRepository {
    private final Scanner scanner = new Scanner(System.in);

    public int getDecimalPlacesFromUser() {
        System.out.print("Enter the number of decimal places: ");
        if (!scanner.hasNextInt()) {
            throw new InvalidInputException("Invalid input! Please enter a valid number.");
        }
        return scanner.nextInt();
    }

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

    public String getSeparatorTypeFromUser() {
        System.out.print("Enter the separator type ('.' or ','): ");
        String separator = scanner.next();
        if (!separator.equals(".") && !separator.equals(",")) {
            throw new InvalidInputException("Separador inválido! Use '.' ou ','.");
        }
        return separator;
    }

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

    public void formatAndPrintValues(List<Double> values, String separatorType, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setDecimalSeparator(separatorType.charAt(0));
        DecimalFormat formatter = new DecimalFormat("#" + separatorType + "##", symbols);

        for (double value : values) {
            System.out.println("Valor Formatado: " + formatter.format(value));
        }
    }
}
