package practice.hw.t02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * כתוב פונקציה רקורסיבית שמקבלת מספר שלם והופכת סדר הספרות, ומחזירה את התוצאה.
 */
public class Q4 {

    private static int reverse(int n) {
        if (n == 0) return 0;
        int m = n, count = 0;
        while (m > 0) {
            count++;
            m = m / 10;
        }
        return reverse(n, count);
    }

    private static int reverse(int n, int length) {
        if (length == 1) {
            return n;
        } else {
            int b = n % 10;
            n = n / 10;
            return (int) ((b * Math.pow(10, length - 1)) + reverse(n, --length));
        }
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
