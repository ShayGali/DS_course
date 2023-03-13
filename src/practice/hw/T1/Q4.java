package practice.hw.T1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * כתוב פונקציה שמקבלת מערך של מספרים שלמים ומדפיסה את שני האברים שערך מוחלט של ההפרש בינם הוא קטן היותר.  מהי סיבוכיות של האלגוריתם?
 */
public class Q4 {

    // sorting - O(n*log(n))
    private static int[] largestAbsDifference(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }


    // brute force - O(n^2)
    private static int[] largestAbsDifference2(int[] arr) {
        int[] res = new int[2];
        int smallestAbs = Integer.MIN_VALUE;

        int calc;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                calc = Math.abs(arr[i] - arr[j]);
                if (calc > smallestAbs) {
                    smallestAbs = calc;
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }

        return res;
    }

    @Test
    void testLargestAbsDifference() {
        int[] arr1 = {5, 8, 10, 13, 6};
        int[] res1 = largestAbsDifference(arr1);
        assertArrayEquals(new int[]{5, 13}, res1);

        int[] arr2 = {-10, 8, -20, 15, 30};
        int[] res2 = largestAbsDifference(arr2);
        assertArrayEquals(new int[]{-20, 30}, res2);

        int[] arr3 = {1, 3, 5, 7, 9};
        int[] res3 = largestAbsDifference(arr3);
        assertArrayEquals(new int[]{1, 9}, res3);
    }
}
