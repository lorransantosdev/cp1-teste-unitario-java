package org.example.controller;

import org.example.exception.InvalidFormatException;
import org.example.service.ValueFormatterService;

public class ValueFormatterController {
    private final ValueFormatterService service;

    public ValueFormatterController(ValueFormatterService service) {
        this.service = service;
    }

    public void startFormattingProcess() {
        int amountFormatDecimal = service.startProcessFormatting();
        if ((amountFormatDecimal > 0)) {
            System.out.println("Foram formatados " + amountFormatDecimal + "valores decimais");
        } else {
            throw new InvalidFormatException("Nenhum valor foi formatada");
        }
    }
}
