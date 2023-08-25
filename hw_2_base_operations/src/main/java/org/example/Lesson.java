package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class Lesson {
    public static void time(BufferedReader reader) throws IOException {
        System.out.print("Enter lesson number (from 1 to 10): ");
        int lessonNumber = Integer.parseInt(reader.readLine());

        int totalMinutes = 540 + lessonNumber * 45 + (5 * (lessonNumber / 2)) + (15 * ((lessonNumber - 1) / 2));

        int endHour = totalMinutes / 60;
        int endMinute = totalMinutes % 60;

        System.out.println("Lesson end time: " + endHour + ":" + endMinute);

        reader.close();
    }
}