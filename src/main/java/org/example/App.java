package org.example;

import org.example.controller.ValueFormatterController;
import org.example.repository.impl.ValueFormatterImpl;
import org.example.service.ValueFormatterService;

public class App {
    private final ValueFormatterController controller;

    public App(ValueFormatterController controller) {
        this.controller = controller;
    }

    public void start() {
        controller.startFormattingProcess();
    }

    public static void main(String[] args) {

        ValueFormatterController controller = new ValueFormatterController(new ValueFormatterService(new ValueFormatterImpl()));

        App app = new App(controller);
        app.start();
    }
}