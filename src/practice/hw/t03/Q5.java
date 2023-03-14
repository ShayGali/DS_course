package practice.hw.t03;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * כתוב פונקציה שמקבלת מערך ממוין של שלמים ומדפיסה את האיבר שמופיע יותר מ- N/2 פעמים. אם איבר כזה אינו קיים הפונקציה מדפיסה הודעה מתאימה בסיבוכיות של O(N).
 */
public class Q5 {
    private static int func(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[i + arr.length / 2]) return arr[i];
        }
        if (arr.length % 2 == 1 && arr[arr.length / 2] == arr[arr.length - 1]) return arr[arr.length - 1];

        throw new NoSuchElementException("There is not element that appear n/2 times");
    }

    @Test
    public void testFunction() {
        int[] arr1 = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr4 = {1, 1, 1, 1, 1, 1, 2, 2, 2};
        int[] arr5 = {1, 1, 1, 1, 1};
        int[] arr6 = {};
        int[] arr7 = {1};
        int[] arr8 = {1, 1};
        int[] arr9 = {1, 2};

        assertEquals(3, func(arr1));
        assertThrows(NoSuchElementException.class, () -> func(arr2));
        assertThrows(NoSuchElementException.class, () -> func(arr3));
        assertEquals(1, func(arr4));
        assertEquals(1, func(arr5));
        assertThrows(NoSuchElementException.class, () -> func(arr6));
        assertEquals(1, func(arr7));
        assertEquals(1, func(arr8));
        assertThrows(NoSuchElementException.class, () -> func(arr9));

    }
}
