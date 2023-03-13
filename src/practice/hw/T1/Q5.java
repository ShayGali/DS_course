package practice.hw.T1;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * נתון מערך שמכיל  מספרים שלמים מ-1 עד 100. למיין את המערך בסיבוכיות של  O(N)
 */
public class Q5 {
    private static void sort(int[] arr) {
        int[] counter = new int[100];
        for (int n : arr) {
            counter[n - 1]++;
        }
        int j = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                arr[j++] = i + 1;
                counter[i]--;
            }
        }

    }

    private static int[] randArray() {
        Random r = new Random();
        int[] res = new int[r.nextInt(10)];
        for (int i = 0; i < res.length; i++) {
            res[i] = r.nextInt(100) + 1;
        }
        return res;
    }

    @RepeatedTest(1000)
    void test() {
        int[] arr = randArray(), clone = arr.clone();
        sort(clone);
        Arrays.sort(arr);
        assertArrayEquals(arr, clone);
    }
}
