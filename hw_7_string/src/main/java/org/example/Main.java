package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        program();
        menu();

        String position;
        while ((position = reader.readLine()) != null) {
            option(position, reader);
            menu();
        }
    }

    private static void program() {
        System.out.println();
        System.out.println("Program STRING");
        System.out.println("Welcome to the program STRING. A simple a program with a little functionality, " +
                "but can reverse the string using three methods");
    }

    private static void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("To create a new string please enter 1");
        System.out.println("To reverse the string please enter 2");
        System.out.println("To reverse the substring in string please enter 3");
        System.out.println("To reverse the string by index please enter 4");
        System.out.println("To close app please enter 5");
    }

    private static void option(String position, BufferedReader reader) throws IOException {

        switch (position) {

            case "1" -> {
                System.out.println("Please enter the string");
                Turner.src = reader.readLine();

                System.out.println("Your string has been created successfully");
            }

            case "2" -> {
                if (Turner.exist()) {
                    System.out.println(Turner.reverse(Turner.src));
                } else {
                    System.out.println("You didn't create a string");
                }
            }

            case "3" -> {
                if (Turner.exist()) {
                    System.out.println("Please enter the substring");
                    System.out.println(Objects.requireNonNullElse(Turner.reverse(Turner.src, reader.readLine()),
                            "No match found"));
                } else {
                    System.out.println("You didn't create a string");
                }
            }

            case "4" -> {
                if (Turner.exist()) {
                    System.out.println("Enter the first index");
                    int firstIndex = Integer.parseInt(reader.readLine());

                    System.out.println("Enter the last index");
                    int lastIndex = Integer.parseInt(reader.readLine());

                    if (firstIndex >= 0 && lastIndex < Turner.src.length() && firstIndex <= lastIndex) {
                        System.out.println(Turner.reverse(Turner.src, firstIndex, lastIndex));
                    } else {
                        System.out.println("Invalid index");
                    }
                } else {
                    System.out.println("You didn't create a string");
                }
            }

            case "5" -> {
                System.out.print("Goodbye!");
                System.exit(0);
            }
        }
    }
}
