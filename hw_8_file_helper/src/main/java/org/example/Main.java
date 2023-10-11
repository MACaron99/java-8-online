package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        program();
        menu();
        current();
        String position;
        while ((position = reader.readLine()) != null) {
            option(position, reader);
            menu();
            current();
        }
    }

    private static void program() {
        System.out.println();
        System.out.println("Program FILE HELPER");
        System.out.println("Welcome to the program FILE HELPER. A simple a program to find, create and delete files and directories");
    }

    private static void current() {
        System.out.println("Current directory " + FileHelper.current);
    }

    private static void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1. List all elements in current directory");
        System.out.println("2. Go to selected directory");
        System.out.println("3. Return to previous directory");
        System.out.println("4. Create new file in current directory");
        System.out.println("5. Create new folder in current directory");
        System.out.println("6. Delete file in current directory");
        System.out.println("7. Delete folder in current directory");
        System.out.println("8. Move file or folder from current directory to specified directory");
        System.out.println("9. Search for file or folder in current directory");
        System.out.println("10. Search for text in files of folders in current directory");
        System.out.println("0. Close the program");
    }

    private static void option(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> FileHelper.list(FileHelper.current);
            case "2" -> {
                System.out.println("Please enter the name of the directory you want to go");
                FileHelper.go(reader.readLine());
            }
            case "3" -> {
                if (!FileHelper.history.empty()) FileHelper.current = FileHelper.history.pop();
            }
            case "4" -> {
                System.out.println("Please enter the name of the file");
                FileHelper.createFile(reader.readLine());
            }
            case "5" -> {
                System.out.println("Please enter the name of the folder");
                FileHelper.createDirectory(reader.readLine());
            }
            case "6" -> {
                System.out.println("Please enter the name of the file you want to delete");
                FileHelper.deleteFile(reader.readLine());
            }
            case "7" -> {
                System.out.println("Please enter the name of the folder you want to delete");
                FileHelper.deleteDirectory(new File(FileHelper.current, reader.readLine()));
            }
            case "8" -> {
                System.out.println("Please enter the name of the file or folder you want to move to");
                String name = reader.readLine();
                System.out.println("Please enter the destination path of the file or folder you want to move to");
                String dest = reader.readLine();
                FileHelper.move(FileHelper.current, dest, name);
            }
            case "9" -> {
                System.out.println("Please enter the name of the file or folder you want to find");
                FileHelper.search(reader.readLine());
            }
            case "10" -> {
                System.out.println("Please enter the text you want to find");
                FileHelper.searchForText(reader.readLine(), new File(FileHelper.current));
            }
            case "0" -> {
                System.out.print("Goodbye!");
                System.exit(0);
            }
        }
    }
}