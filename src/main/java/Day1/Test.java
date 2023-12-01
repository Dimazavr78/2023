package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\adventofcode.com_2023_day_1_input.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                System.out.println(str);
            }}
        String[] document = list.toArray(new String[0]);


        int totalCalibration = calculateTotalCalibration(document);
        System.out.println("Total Calibration: " + totalCalibration);
    }
    public static int calculateTotalCalibration(String[] document) {
        int totalCalibration = 0;

        for (String line : document) {
            int firstDigit = findFirstDigit(line);
            int lastDigit = findLastDigit(line);
            int calibrationValue = concatenateDigits(firstDigit, lastDigit);
            totalCalibration += calibrationValue;
        }

        return totalCalibration;
    }

    private static int findFirstDigit(String line) {
        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
                return Character.getNumericValue(ch);
            }
        }
        return 0; // Вернуть 0, если цифра не найдена
    }

    private static int findLastDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                return Character.getNumericValue(line.charAt(i));
            }
        }
        return 0; // Вернуть 0, если цифра не найдена
    }

    private static int concatenateDigits(int firstDigit, int lastDigit) {
        return firstDigit * 10 + lastDigit;
    }
}
