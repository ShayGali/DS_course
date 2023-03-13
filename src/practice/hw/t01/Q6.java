package practice.hw.t01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * כתוב פונקציה סטטית שמקבלת מערך ממוין בסדר עולה של מספרים שלמים.
 * הפונקציה מחזירה true אם במערך יש שני איברים שסכומם שווה לאפס, אחרת היא מחזירה false.
 * הסיבוכיות הנדרשת  O(N),  N – גודל המערך
 */
public class Q6 {
    private static boolean hasSumOfZero(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == 0) return true;
            if (arr[r] + arr[l] < 0) l++;
            else r--;
        }
        return false;
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertFalse(hasSumOfZero(arr));
    }

    @Test
    void testArrayWithOneElement() {
        int[] arr = {5};
        assertFalse(hasSumOfZero(arr));
    }

    @Test
    void testArrayWithTwoElementsAndSumOfZero() {
        int[] arr = {-2, 2};
        assertTrue(hasSumOfZero(arr));
    }

    @Test
    void testArrayWithTwoElementsAndSumNotZero() {
        int[] arr = {-2, 3};
        assertFalse(hasSumOfZero(arr));
    }

    @Test
    void testArrayWithThreeElementsAndSumNotZero() {
        int[] arr = {-3, 1, 2};
        assertFalse(hasSumOfZero(arr));
    }

    @Test
    void testArrayWithThreeElementsAndSumOfZero() {
        int[] arr = {-3, 1, 3};
        assertTrue(hasSumOfZero(arr));
    }
}
