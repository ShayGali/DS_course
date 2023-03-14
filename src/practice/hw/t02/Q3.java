package practice.hw.t02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * כתוב פונקציה לא רקורסיבית שמקבלת מספר שלם והופכת סדר הספרות, ומחזירה את התוצאה.
 */
public class Q3 {
    private static int reverse(int n) {
        int res = 0;
        while (n != 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    @Test
    void testReverseIntegerWithPositiveNumber() {
        int result = reverse(12345);
        assertEquals(54321, result);
    }

    @Test
    void testReverseIntegerWithZero() {
        int result = reverse(0);
        assertEquals(0, result);
    }

    @Test
    void testReverseIntegerWithSingleDigitNumber() {
        int result = reverse(9);
        assertEquals(9, result);
    }

}
