package homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingByCounting {
    public static void main(String[] args) throws IOException {
        int[] test = readNumbersFromConsole();
        sortByCounting(test);
    }

    public static void sortByCounting(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int[] buckets = new int[range];

        for (int element : array) {
            buckets[element - min]++;
        }

        int arrayIndex = 0;

        for (int i = 0; i < buckets.length; i++) {
            for (int j = buckets[i]; j > 0; j--) {
                array[arrayIndex++] = i + min;
            }
        }
        showArrayOnDisplay(array);
    }

    public static void showArrayOnDisplay(int[] array) {
        Arrays.stream(array)
                .forEach(x -> System.out.print(x + " "));
    }

    public static int[] readNumbersFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String inputString = "";
        StringBuilder builder = new StringBuilder();
        System.out.println("Please enter numbers from the keyboard.Please avoid any characters except digits. " +
                "If you want get a result, enter \"exit\" from the beginning of the next line");
        do {
            inputString = reader.readLine();
            if (inputString.equalsIgnoreCase("exit")) {
                System.out.println("Your result is: ");
                break;
            }
            if (inputString.matches("^[a-zA-Z]+?|\\p{Punct}")
                    || inputString.startsWith(" ")
                    || inputString.equals("")) {
                System.out.println("Input is invalid, try again: ");
            } else if (inputString.contains(".")) {
                System.out.println("Decimal point is not allowed");
            } else {
                String readyForAppending = inputString.trim().replaceAll("\\s+", " ");
                builder.append(readyForAppending).append(" ");
            }
        } while (!inputString.equalsIgnoreCase("exit"));

        String[] stringsArray = builder.toString().trim().split(" ");
        for (String s : stringsArray) {
            if (lineValidation(s)) {
                list.add(Integer.parseInt(s));
            }
        }

        int[] finalResult = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            finalResult[i] = list.get(i);
        }
        return finalResult;
    }

    public static boolean lineValidation(String stringForTesting) {
        int counter = 0;
        char[] chars = stringForTesting.trim().toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar) && !String.valueOf(aChar).equals("-")) {
                counter++;
            }
        }
        return counter == 0;
    }
}


