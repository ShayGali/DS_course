package practice.hw.t4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * כתוב פונקציה שמקבלת שלושה מערכים ממוינים בסדר עולה של מספרים שלמים, מאחדת אותם למערך ממוין בסדר עולה ומחזירה אותו.
 */
public class Q1 {
    // marge a1&a2, and then marge the result with a3
    private static int[] margeThree(int[] a1, int[] a2, int[] a3) {
        return margeTwo(margeTwo(a1, a2), a3);
    }

    private static int[] margeTwo(int[] a1, int[] a2) {
        int i = 0, j = 0;
        int[] res = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                res[i + j] = a1[i];
                i++;
            } else {
                res[i + j] = a2[j];
                j++;
            }
        }

        while (i < a1.length) {
            res[i + j] = a1[i];
            i++;
        }
        while (j < a2.length) {
            res[i + j] = a2[j];
            j++;
        }
        return res;
    }

    // run on three arrays
    private static int[] margeThree2(int[] a1, int[] a2, int[] a3) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[a1.length + a2.length + a3.length];
        while (i < a1.length && j < a2.length && k < a3.length) {
            if (a1[i] <= a2[j] && a1[i] <= a3[k]) {
                res[i + j + k] = a1[i];
                i++;
            } else if (a2[j] <= a1[i] && a2[j] <= a3[k]) {
                res[i + j + k] = a2[j];
                j++;
            } else {
                res[i + j + k] = a3[k];
                k++;
            }
        }

        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                res[i + j + k] = a1[i];
                i++;
            } else {
                res[i + j + k] = a2[j];
                j++;
            }
        }

        while (i < a1.length && k < a3.length) {
            if (a1[i] <= a3[k]) {
                res[i + j + k] = a1[i];
                i++;
            } else {
                res[i + j + k] = a3[k];
                k++;
            }
        }
        while (j < a2.length && k < a3.length) {
            if (a2[j] <= a3[k]) {
                res[i + j + k] = a2[j];
                j++;
            } else {
                res[i + j + k] = a3[k];
                k++;
            }
        }

        while (i < a1.length) {
            res[i + j + k] = a1[i];
            i++;
        }
        while (j < a2.length) {
            res[i + j + k] = a2[j];
            j++;
        }
        while (k < a3.length) {
            res[i + j + k] = a3[k];
            k++;
        }
        return res;
    }


    @Test
    void testEmptyArrays() {
        // Test with empty arrays
        assertArrayEquals(new int[]{}, margeThree(new int[]{}, new int[]{}, new int[]{}));
        assertArrayEquals(new int[]{1, 2, 3}, margeThree(new int[]{1, 2, 3}, new int[]{}, new int[]{}));
        assertArrayEquals(new int[]{1, 2, 3}, margeThree(new int[]{}, new int[]{1, 2, 3}, new int[]{}));
        assertArrayEquals(new int[]{1, 2, 3}, margeThree(new int[]{}, new int[]{}, new int[]{1, 2, 3}));
    }

    @Test
    void testDifferentLengths() {
        // Test with different lengths of arrays
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, margeThree(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8}, new int[]{9}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, margeThree(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7, 8}, new int[]{9}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, margeThree(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7}, new int[]{8, 9}));
    }

    @Test
    void testEqualLengths() {
        // Test with arrays of equal length
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, margeThree(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, margeThree(new int[]{}, new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3}, margeThree(new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{}));
    }

    @Test
    void testNegativeNumbers() {
        // Test with negative numbers
        assertArrayEquals(new int[]{-6, -5, -4, -3, -2, -1}, margeThree(new int[]{-6, -5, -4}, new int[]{-3, -2}, new int[]{-1}));
        assertArrayEquals(new int[]{-6, -5, -4, -3, -2, -1}, margeThree(new int[]{-3, -2}, new int[]{-6, -5, -4}, new int[]{-1}));
    }

    @Test
    void testLargeArrays() {
        // Test with large arrays
        int[] large1 = new int[1000];
        int[] large2 = new int[1000];
        int[] large3 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            large1[i] = i * 2;
            large2[i] = i * 2 + 1;
            large3[i] = i * 3;
        }
        int[] merged = margeThree(large1, large2, large3);
        for (int i = 0; i < 999; i++) {
            assertTrue(merged[i] <= merged[i + 1]);
        }
    }
}
