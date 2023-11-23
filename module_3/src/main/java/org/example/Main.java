package org.example;

import org.example.controller.Controller;
import org.example.factory.JdbcFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JdbcFactory.getInstance().initDB(Main.class);
        new Controller().start();
    }
}