package org.example;

import org.example.controller.ValueFormatterController;

public class App {
    public static void main(String[] args) {
        ValueFormatterController controller = new ValueFormatterController();
        controller.startFormattingProcess();
    }
}