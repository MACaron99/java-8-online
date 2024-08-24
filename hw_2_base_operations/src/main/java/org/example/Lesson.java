package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Lesson {

    public static void time(BufferedReader reader) throws IOException {

        System.out.println("Program 3 - The end of the lesson");
        System.out.println("Description: defines when the specified lesson ends.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start time of the lessons with a space: ");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");

        int startHour;
        int startMinute;

        if (parts.length == 2) {
            try {
                startHour = Integer.parseInt(parts[0]);
                startMinute = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e){
                System.out.println("One of the variables is not a number.");
                return;
            }
        } else {
            System.out.println("Enter exactly two variables separated by a space.");
            return;
        }

        System.out.print("Enter lesson duration in minutes: ");
        int lessonDuration = Integer.parseInt(reader.readLine());

        System.out.print("Enter the duration of breaks after odd lessons: ");
        int oddBreak = Integer.parseInt(reader.readLine());

        System.out.print("Enter the duration of breaks after even lessons: ");
        int evenBreak = Integer.parseInt(reader.readLine());

        System.out.print("Enter lesson number (from 1 to 10): ");
        int lessonNumber = Integer.parseInt(reader.readLine());

        int startTime = 60 * startHour + startMinute;
        int totalMinutes = startTime + lessonNumber * lessonDuration + (oddBreak * (lessonNumber / 2))
                + (evenBreak * ((lessonNumber - 1) / 2));

        int endHour = totalMinutes / 60;
        int endMinute = totalMinutes % 60;

        System.out.println("Lesson end time: " + endHour + ":" + endMinute);
    }
}
