package homework;


import java.util.Arrays;

public class SortingByCounting {
    public static void main(String[] args) {
        int[] a = {54, 50, 51, 50, 53, 52, 51, 50};
        sortByCounting(a);
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
    }
}

