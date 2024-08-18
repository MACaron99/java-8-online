package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    MatList<Integer> mathList = new MatList<>();

    public void start() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        program();
        menu();

        String position;
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void print(Number[] numbers) {
        System.out.println();
        System.out.println(" Your MatList");
        System.out.print("[ ");

        for (Number number : numbers) {
            if (number != null) {
                System.out.print(number + " ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    private void program() {
        System.out.println();
        System.out.println("Program MAT LIST");
        System.out.println("Welcome to the program MAT LIST. Simple application for statistical analysis of the list.");
    }

    private void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("To add a number please enter 1");
        System.out.println("To add n numbers please enter 2");
        System.out.println("To read list please enter 3");
        System.out.println("To read list by index please enter 4");
        System.out.println("To join another mat list please enter 5");
        System.out.println("To join another mat list leaving common numbers please enter 6");
        System.out.println("To sort list from the largest please enter 7");
        System.out.println("To sort list from the largest in range please enter 8");
        System.out.println("To sort list from the largest beginning with the value please enter 9");
        System.out.println("To sort list from the smallest please enter 10");
        System.out.println("To sort list from the smallest in range please enter 11");
        System.out.println("To sort list from the largest beginning with the value please enter 12");
        System.out.println("To get number by index please enter 13");
        System.out.println("To get maximum value of the list please enter 14");
        System.out.println("To get minimum value of the list please enter 15");
        System.out.println("To get average value of the list please enter 16");
        System.out.println("To get median of the list please enter 17");
        System.out.println("To cut the part of the list by index please enter 18");
        System.out.println("To clear a list please enter 19");
        System.out.println("To clear element by value please enter 20");
        System.out.println("If you want close app please enter 21");
    }

    private void crud(String position, BufferedReader reader) throws IOException {

        switch (position) {

            case "1" -> {
                System.out.println("Please enter the number");
                int number = Integer.parseInt(reader.readLine());

                mathList.add(number);

                System.out.println("The number has successfully added to the mat list");
            }

            case "2" -> {
                System.out.println("Please enter the numbers");
                String string = reader.readLine();

                String[] array = string.split("");

                for (String s : array) {
                    mathList.add(Integer.parseInt(s));
                }
                System.out.println("The numbers have successfully added to the mat list");
            }

            case "3" -> print(mathList.findAll());

            case "4" -> {
                System.out.println("Enter the first index");
                int firstIndex = Integer.parseInt(reader.readLine());

                System.out.println("Enter the last index");
                int lastIndex = Integer.parseInt(reader.readLine());

                print(mathList.toArray(firstIndex, lastIndex));
            }

            case "5" -> {
                System.out.println();
                System.out.println("Let's create new mat list: ");
                System.out.println("Please enter the numbers of the other mat list");
                String string = reader.readLine();

                String[] array = string.split("");
                Integer[] intArray = new Integer[array.length];

                for(int i = 0; i < array.length; i++) {
                    intArray[i] = Integer.parseInt(array[i]);
                }
                MatList<Integer> otherList = new MatList<>(intArray);

                mathList.join(otherList);

                System.out.println("Your mat lists are successfully joined");
            }

            case "6" -> {
                System.out.println();
                System.out.println("Let's create new mat list: ");
                System.out.println("Please enter the numbers of the other mat list");
                String string = reader.readLine();

                String[] array = string.split(" ");
                Integer[] intArray = new Integer[array.length];

                for(int i = 0; i < array.length; i++) {
                    intArray[i] = Integer.parseInt(array[i]);
                }
                MatList<Integer> otherList = new MatList<>(intArray);

                mathList.intersection(otherList);

                System.out.println("Your mat lists are successfully joined leaving common numbers");
            }

            case "7" -> {
                mathList.sortDesc();

                print(mathList.findAll());
            }

            case "8" -> {
                System.out.println("Enter the first index");
                int firstIndex = Integer.parseInt(reader.readLine());

                System.out.println("Enter the last index");
                int lastIndex = Integer.parseInt(reader.readLine());

                mathList.sortDesc(firstIndex, lastIndex);

                print(mathList.findAll());
            }

            case "9" -> {
                System.out.println("Enter the value");
                int value = Integer.parseInt(reader.readLine());

                mathList.sortDesc(value);

                print(mathList.findAll());
            }

            case "10" -> {
                mathList.sortAsc();

                print(mathList.findAll());
            }

            case "11" -> {
                System.out.println("Enter the first index");
                int firstIndex = Integer.parseInt(reader.readLine());

                System.out.println("Enter the last index");
                int lastIndex = Integer.parseInt(reader.readLine());

                mathList.sortAsc(firstIndex, lastIndex);

                print(mathList.findAll());
            }

            case "12" -> {
                System.out.println("Enter the value");
                int value = Integer.parseInt(reader.readLine());

                mathList.sortAsc(value);

                print(mathList.findAll());
            }

            case "13" -> {
                System.out.println("Enter the index");
                int index = Integer.parseInt(reader.readLine());

                System.out.println("Your number: " + mathList.get(index));
            }

            case "14" -> System.out.println("Max value: " + mathList.getMax());

            case "15" -> System.out.println("Min value: " + mathList.getMin());

            case "16" -> System.out.println("Average value: " + mathList.getAverage());

            case "17" -> System.out.println("Median: " + mathList.getMedian());

            case "18" -> {
                System.out.println("Enter the first index");
                int firstIndex = Integer.parseInt(reader.readLine());

                System.out.println("Enter the last index");
                int lastIndex = Integer.parseInt(reader.readLine());

                mathList.cut(firstIndex, lastIndex);

                print(mathList.findAll());
            }

            case "19" -> {
                mathList.clear();

                System.out.println("Cleared");
            }

            case "20" -> {
                System.out.println("Please enter the numbers");
                String string = reader.readLine();

                String[] array = string.split(" ");
                Integer[] values = new Integer[array.length];

                for(int i = 0; i < array.length; i++) {
                    values[i] = Integer.parseInt(array[i]);
                }

                mathList.clear(values);

                System.out.println("Cleared");
            }

            case "21" -> {
                System.out.print("Goodbye!");
                System.exit(0);
            }
        }
    }
}
