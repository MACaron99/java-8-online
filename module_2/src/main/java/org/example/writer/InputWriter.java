package org.example.writer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class InputWriter {

    public static void write() {
        File file = new File("input.txt");

        if (!file.exists()) {

            try (PrintWriter writer = new PrintWriter("input.txt")) {
                writer.println("15");

                writer.println("berlin");
                writer.println("4");
                writer.println("2 29");
                writer.println("3 29");
                writer.println("4 19");
                writer.println("5 19");

                writer.println("hamburg");
                writer.println("3");
                writer.println("1 29");
                writer.println("3 16");
                writer.println("6 13");

                writer.println("hannover");
                writer.println("6");
                writer.println("1 29");
                writer.println("2 16");
                writer.println("4 27");
                writer.println("6 14");
                writer.println("7 21");
                writer.println("8 35");

                writer.println("leipzig");
                writer.println("6");
                writer.println("1 19");
                writer.println("3 27");
                writer.println("5 12");
                writer.println("8 40");
                writer.println("9 29");
                writer.println("14 48");

                writer.println("dresden");
                writer.println("4");
                writer.println("1 19");
                writer.println("4 12");
                writer.println("8 47");
                writer.println("9 31");

                writer.println("bremen");
                writer.println("4");
                writer.println("2 13");
                writer.println("3 14");
                writer.println("7 23");
                writer.println("10 25");

                writer.println("dortmund");
                writer.println("4");
                writer.println("3 21");
                writer.println("6 23");
                writer.println("8 23");
                writer.println("10 4");

                writer.println("frankfurt");
                writer.println("7");
                writer.println("3 35");
                writer.println("4 40");
                writer.println("5 47");
                writer.println("7 23");
                writer.println("9 23");
                writer.println("13 18");
                writer.println("14 21");

                writer.println("nurnberg");
                writer.println("5");
                writer.println("4 29");
                writer.println("5 31");
                writer.println("8 23");
                writer.println("14 21");
                writer.println("15 17");

                writer.println("essen");
                writer.println("3");
                writer.println("6 25");
                writer.println("7 4");
                writer.println("11 4");

                writer.println("dusseldorf");
                writer.println("2");
                writer.println("10 4");
                writer.println("12 4");

                writer.println("koln");
                writer.println("2");
                writer.println("11 4");
                writer.println("13 4");

                writer.println("bonn");
                writer.println("2");
                writer.println("8 18");
                writer.println("12 4");

                writer.println("stuttgart");
                writer.println("4");
                writer.println("4 48");
                writer.println("8 21");
                writer.println("9 21");
                writer.println("15 23");

                writer.println("munchen");
                writer.println("2");
                writer.println("9 17");
                writer.println("14 23");

                writer.println("3");

                writer.println("berlin frankfurt");
                writer.println("koln munchen");
                writer.println("stuttgart bremen");

            } catch (IOException e) {
                System.out.println("e = " + e.getMessage());
            }
        }
    }
}
