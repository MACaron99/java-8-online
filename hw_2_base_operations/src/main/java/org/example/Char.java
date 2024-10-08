package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Char {

    public static void read(BufferedReader reader) throws IOException {

        System.out.println("Program 2 - The number of occurrences of each character");
        System.out.println("Description: takes a string from the console and extracts all Latin/Cyrillic characters " +
                "and sorts them, indicating the number of occurrences of each character.");
        System.out.print("Enter the string: ");

        String inputString = reader.readLine();

        Map<Character, Integer> charCountMap = countAndSortLatinCharacters(inputString);

        int count = 1;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(count + ". " + entry.getKey() + " - " + entry.getValue());
            count++;
        }

    }

    public static Map<Character, Integer> countAndSortLatinCharacters(String inputString) {

        Map<Character, Integer> charCountMap = new TreeMap<>();

        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            char character = matcher.group().charAt(0);
            charCountMap.put(character, charCountMap.getOrDefault(character, 0) + 1);
        }

        return charCountMap;
    }
}
