package practice.hw.t01;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * מצא את אלגוריתם יעיל, המחזיר את האיבר ה-n בגודלו מתוך מערך לא ממוין.
 * הערה: אין למיין את המערך ואחר כך למצוא את האיבר. מהי סיבוכיות של האלגוריתם?
 */
public class Q1 {

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int nThLargestNumber(int[] arr, int n) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        return nThLargestNumberHelp(temp, n, 0, arr.length - 1);
    }

    private static int nThLargestNumberHelp(int[] arr, int n, int l, int r) {
        int pivotIndex = partition(arr, l, r);
        if (pivotIndex == n) return arr[pivotIndex];
        if (pivotIndex < n) {
            return nThLargestNumberHelp(arr, n, pivotIndex + 1, r);
        }
        return nThLargestNumberHelp(arr, n, l, pivotIndex - 1);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int partitionIndex = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, partitionIndex++);
            }
        }
        swap(arr, r, partitionIndex);
        return partitionIndex;
    }

    @Test
    void simpleTest() {
        int[] arr = IntStream.range(0, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i, nThLargestNumber(arr, i));
        }
    }

    @RepeatedTest(200)
    void shuffleRepeatedTest() {
        int[] arr = IntStream.range(0, 100).toArray();
        shuffleArray(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i, nThLargestNumber(arr, i));
        }
    }

    private static void shuffleArray(int[] arr) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(arr, i, index);
        }
    }
}
