package practice.hw.t4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * כתוב פונקציה בוליאנית שמקבלת מערך של מספרים שלמים שונים, המערך ממוין בסדר עולה.
 * הפונקציה מחזירה אמת אם קיים איבר בתוך מערך השווה לאינדקס שלו, כלומר כזה ש- arr[i]==i. מצא אלגוריתם שהסיבוכיות שלו O(log(n)).
 */
public class Q2 {

    private static boolean algo(int[] arr) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == mid) return true;
            if (arr[mid] > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }


    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertFalse(algo(arr));
    }

    @Test
    void testArrayWithNoMatch() {
        int[] arr = {-3, -1, 0, 2, 5};
        assertFalse(algo(arr));
    }

    @Test
    void testArrayWithSingleMatch() {
        int[] arr = {-3, -1, 0, 3, 5};
        assertTrue(algo(arr));
    }

    @Test
    void testArrayWithMultipleMatches() {
        int[] arr = {-2, 1, 2, 3, 4, 5};
        assertTrue(algo(arr));
    }

    @Test
    void testArrayWithAllMatches() {
        int[] arr = {0, 1, 2, 3, 4, 5};
        assertTrue(algo(arr));
    }

}
