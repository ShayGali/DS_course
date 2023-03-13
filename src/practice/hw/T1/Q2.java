package practice.hw.T1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Q2 {
    private static int[] frequenciesArray(String[] arr) {
        if (arr.length == 0) return new int[0];

        int uniqueWords = 1;
        String prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (!prev.equals(arr[i])) {
                uniqueWords++;
                prev = arr[i];
            }
        }
        int[] res = new int[uniqueWords];
        prev = arr[0];
        res[0] = 1;
        for (int i = 1, j = 0; i < arr.length; i++) {
            if (prev.equals(arr[i])) {
                res[j]++;
            } else {
                prev = arr[i];
                res[++j]++;
            }
        }
        return res;
    }


    @Test
    void qExample() {
        String[] words = {"be", "be", "not", "or", "to", "to", "to"};
        assertArrayEquals(new int[]{2, 1, 1, 3}, frequenciesArray(words));
    }

    @Test
    void testEmptyArray() {
        String[] words = {};
        int[] expected = {};
        assertArrayEquals(expected, frequenciesArray(words));
    }

    @Test
    void testSingleWord() {
        String[] words = {"hello"};
        int[] expected = {1};
        assertArrayEquals(expected, frequenciesArray(words));
    }

    @Test
    void testMultipleWords() {
        String[] words = {"apple", "banana", "banana", "cherry", "cherry", "cherry", "orange"};
        int[] expected = {1, 2, 3, 1};
        assertArrayEquals(expected, frequenciesArray(words));
    }

    @Test
    void testAllSameWord() {
        String[] words = {"dog", "dog", "dog", "dog", "dog"};
        int[] expected = {5};
        assertArrayEquals(expected, frequenciesArray(words));
    }

    @Test
    void testRandomWords() {
        String[] words = {"alpha", "beta", "gamma", "gamma", "gamma", "delta", "epsilon", "epsilon", "zeta", "zeta"};
        int[] expected = {1, 1, 3, 1, 2, 2};
        assertArrayEquals(expected, frequenciesArray(words));
    }
}
