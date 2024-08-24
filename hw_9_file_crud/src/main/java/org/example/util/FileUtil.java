package org.example.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void fileCheck(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("Failed to create file " + fileName);
                }
            } catch (IOException e) {
                System.out.println("Error while creating a file " + fileName + ": " + e.getMessage());
            }
        }
    }
}
