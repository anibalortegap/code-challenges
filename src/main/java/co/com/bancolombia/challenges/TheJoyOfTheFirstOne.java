package co.com.bancolombia.challenges;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class TheJoyOfTheFirstOne {

    public int[] letsGoParty(int[] bigArray, int resultSize){

        return letsGoParty(bigArray, 0, bigArray.length -1, resultSize);
    }

    private static int[] letsGoParty(int[] bigArray, int low, int high, int resultSize){
        if (low < high) {
            int pivot = partition(bigArray, low, high);
            if (pivot == resultSize) {
                return Arrays.copyOf(bigArray, resultSize);
            } else if (pivot < resultSize) {
                return letsGoParty(bigArray, pivot + 1, high, resultSize);
            } else {
                return letsGoParty(bigArray, low, pivot - 1, resultSize);
            }
        }
        return Arrays.copyOf(bigArray, resultSize);
    }

    private static int partition(int[] bigArray, int low, int high) {
        int pivot = bigArray[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (bigArray[j] <= pivot) {
                i++;
                int temp = bigArray[i];
                bigArray[i] = bigArray[j];
                bigArray[j] = temp;
            }
        }
        int temp = bigArray[i + 1];
        bigArray[i + 1] = bigArray[high];
        bigArray[high] = temp;
        return i + 1;
    }


    public static void main(String[] args) throws IOException {
        TheJoyOfTheFirstOne joy = new TheJoyOfTheFirstOne();

        Random random = new Random(42);
        final IntStream ints = random.ints(200_000_000, 0, Integer.MAX_VALUE);
        int[] array = ints.toArray();

        long init = System.currentTimeMillis();
        final int[] solution = joy.letsGoParty(array, 50);
        System.out.println("Time: " + (System.currentTimeMillis()-init) + "ms");
        System.out.println("Fin");
        System.out.println("First 50: " + Arrays.toString(solution));
    }

}
