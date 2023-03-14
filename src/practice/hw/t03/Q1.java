package practice.hw.t03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1 {
    private static int binarySearch(int[] arr, int value) {
        int l = 0, r = arr.length - 1, mid;

        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == value) return mid;
            if (arr[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] arr3 = {1};
        int[] arr4 = {};

        // Test cases with values that are in the array
        assertEquals(2, binarySearch(arr1, 5));
        assertEquals(0, binarySearch(arr1, 1));
        assertEquals(5, binarySearch(arr1, 11));
        assertEquals(3, binarySearch(arr2, 8));

        // Test cases with values that are not in the array
        assertEquals(-1, binarySearch(arr1, 4));
        assertEquals(-1, binarySearch(arr2, 11));
        assertEquals(-1, binarySearch(arr3, 2));
        assertEquals(-1, binarySearch(arr4, 1));

        // Test case with empty array
        assertEquals(-1, binarySearch(arr4, 5));
    }
}
