package org.example.controller;

import org.example.service.ValueFormatterService;

public class ValueFormatterController {
    private final ValueFormatterService service = new ValueFormatterService();

    public void startFormattingProcess() {
        try {
            service.processFormatting();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
