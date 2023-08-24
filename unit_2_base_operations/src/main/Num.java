import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Num {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string: ");
        String inputString = reader.readLine();

        int totalSum = extractAndSumNumbers(inputString);
        System.out.println("Sum of numbers: " + totalSum);

        reader.close();
    }

    public static int extractAndSumNumbers(String inputString) {
        int totalSum = 0;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            totalSum += number;
        }

        return totalSum;
    }
}