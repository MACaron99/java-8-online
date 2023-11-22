package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Program DICTIONARY");
        System.out.println("Welcome to the program DICTIONARY. An application for working with the dictionary data structure");

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Show the size of the dictionary");
            System.out.println("2. Check if dictionary is empty");
            System.out.println("3. Check for key availability");
            System.out.println("4. Check for value availability");
            System.out.println("5. Get value by key");
            System.out.println("6. Add an element");
            System.out.println("7. Delete element by key");
            System.out.println("8. Add all elements from another dictionary");
            System.out.println("9. Clear dictionary");
            System.out.println("10. Find keys");
            System.out.println("11. Find values");
            System.out.println("12. Exit");

            System.out.print("Choose the operation: ");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Size of dictionary: " + dictionary.size());
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Dictionary is empty: " + dictionary.isEmpty());
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Enter the key: ");
                    String key = reader.readLine();
                    System.out.println("The key is available: " + dictionary.containsKey(key));
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Enter the value: ");
                    int value = Integer.parseInt(reader.readLine());
                    System.out.println("Value is available: " + dictionary.containsValue(value));
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Enter the key: ");
                    key = reader.readLine();
                    Integer findValue = dictionary.get(key);
                    if (findValue != null) {
                        System.out.println("The value by key '" + key + "': " + findValue);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Enter the key: ");
                    key = reader.readLine();
                    System.out.print("Enter the value: ");
                    value = Integer.parseInt(reader.readLine());
                    boolean added = dictionary.put(key, value);
                    if (added) {
                        System.out.println("Element successfully added.");
                    } else {
                        System.out.println("Elements with empty keys or values cannot be added.");
                    }
                    break;
                case 7:
                    System.out.println();
                    System.out.print("Enter the key: ");
                    key = reader.readLine();
                    boolean removed = dictionary.remove(key);
                    if (removed) {
                        System.out.println("Element successfully deleted.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 8:
                    System.out.println();
                    System.out.println("Let's create new dictionary: ");
                    Dictionary<String, Integer> otherDictionary = new Dictionary<>();
                    String answer;
                    do {
                        System.out.println();
                        System.out.print("Enter the key: ");
                        key = reader.readLine();
                        System.out.print("Enter the value: ");
                        value = Integer.parseInt(reader.readLine());
                        boolean truth = otherDictionary.put(key, value);
                        if (truth) {
                            System.out.println("Element successfully added.");
                            System.out.println();
                        } else {
                            System.out.println("Elements with empty keys or values cannot be added.");
                        }
                        System.out.println("Add one more element? Please enter y or n");
                        answer = reader.readLine();
                    } while (answer.equalsIgnoreCase("y"));
                    boolean addedAll = dictionary.putAll(otherDictionary);
                    if (addedAll) {
                        System.out.println("All element are successfully added");
                    } else {
                        System.out.println("Error when adding elements");
                    }
                    break;
                case 9:
                    boolean cleared = dictionary.clear();
                    if (cleared) {
                        System.out.println();
                        System.out.println("Dictionary successfully cleared");
                    }
                    break;
                case 10:
                    System.out.println();
                    System.out.println("Keys in dictionary: " + dictionary.keySet());
                    break;
                case 11:
                    System.out.println();
                    System.out.println("Values in dictionary: " + dictionary.values());
                    break;
                case 12:
                    reader.close();
                    System.exit(0);
                default:
                    System.out.println();
                    System.out.println("Wrong choice. Try again.");
                    break;
            }
        }
    }
}