package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class FileHelper {

    public static String current = System.getProperty("user.home");
    public static Stack<String> history = new Stack<>();

    public static void list(String path) {
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {

            File[] content = dir.listFiles();

            assert content != null;

            for (File file : content) {
                if (file.isFile()) continue;
                System.out.println("folder '" + file.getName() + "'");
            }
            for (File file : content) {
                if (file.isDirectory()) continue;
                System.out.println("file '" + file.getName() + "'");
            }
        } else {
            System.out.println("Directory not found");
        }
    }

    public static void go(String name) {
        File dir = new File(current, name);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                history.push(current);
                current = dir.getAbsolutePath();
            } else {
                System.out.println("Directory not found");
            }
        } else {
            System.out.println("Directory not found");
        }
    }

    public static void createFile(String name) {
        try {
            File newFile = new File(current, name);

            if (newFile.exists()) {
                System.out.println("File '" + newFile.getName() + "' has already exist");
            } else if (newFile.createNewFile()) {
                System.out.println("File '" + newFile.getName() + "' was successfully created");
            } else {
                System.out.println("Error while creating");
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public static void createDirectory(String name) {
        File newDir = new File(current, name);

        if (newDir.exists()) {
            System.out.println("Folder '" + newDir.getName() + "' has already exist");
        } else if (newDir.mkdirs()) {
            System.out.println("Folder '" + newDir.getName() + "' was successfully created");
        } else {
            System.out.println("Error while creating");
        }
    }

    public static void deleteFile(String name) {
        File file = new File(current, name);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.delete()) {
                    System.out.println("File '" + file.getName() + "' was successfully deleted");
                } else {
                    System.out.println("Error while deleting");
                }
            } else {
                System.out.println("File '" + file.getName() + "' not found");
            }
        } else {
            System.out.println("File '" + file.getName() + "' not found");
        }
    }

    public static void deleteDirectory(File dir) {
        if (dir.exists()) {
            if (dir.isDirectory()) {
                File[] content = dir.listFiles();
                if (content != null) {
                    for (File file : content) {
                        if (file.isDirectory()) {
                            deleteDirectory(file);
                        } else if (!file.delete()) {
                            System.out.println("Error while deleting");
                        }
                    }
                }
                if (dir.delete()) {
                    System.out.println("Directory '" + dir.getName() + "' was successfully deleted");
                } else {
                    System.out.println("Error while deleting");
                }
            } else {
                System.out.println("Directory '" + dir.getName() + "' not found");
            }
        } else {
            System.out.println("Directory '" + dir.getName() + "' not found");
        }
    }

    public static void move(String srcDir, String destDir, String name) {
        File src = new File(srcDir, name);
        File dest = new File(destDir);

        if (src.exists() && dest.exists()) {
            File destination = new File(dest, name);

            if (src.renameTo(destination)) {
                System.out.println("'" + name + "' moved successfully");
            }
            else {
                System.out.println("Error while moving");
            }
        } else {
            System.out.println("File or folder '" + name + "' not found");
        }
    }

    public static void search(String name) {
        File dir = new File(current);
        File[] content = dir.listFiles();

        boolean found = false;

        assert content != null;
        for (File file : content) {
            if (file.getName().equals(name)) {
                if (file.isFile()) {
                    System.out.println("File '" + name + "' found by path: " + file.getAbsolutePath());
                } else {
                    System.out.println("Directory '" + name + "' found by path: " + file.getAbsolutePath());
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("'" + name + "' not found");
        }
    }

    public static void searchForText(String text, File dir) {
        if (dir.isDirectory()) {
            File[] content = dir.listFiles();

            boolean found = false;

            assert content != null;
            for (File file : content) {
                if (file.isDirectory()) searchForText(text, file);
                else {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains(text)) {
                                found = true;
                                System.out.println("Text '" + text + "' found in file: " + file.getAbsolutePath());
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("e = " + e.getMessage());
                    }
                }
            }
            if (!found) {
                System.out.println("Text '" + text + "' not found");
            }
        }
    }
}
