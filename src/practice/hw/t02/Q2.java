package practice.hw.t02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q2 {
    private static int powerOfTwo(int n) {
        if (n == 0) return 1;
        return powerOfTwo(n - 1) + powerOfTwo(n - 1);
    }


    @Test
    void testPowerOfTwoWithZero() {
        int result = powerOfTwo(0);
        assertEquals(1, result);
    }

    @Test
    void testPowerOfTwoWithPositiveNumber() {
        int result = powerOfTwo(5);
        assertEquals(32, result);
    }

    @Test
    void testPowerOfTwoWithLargeNumber() {
        int result = powerOfTwo(30);
        assertEquals(1073741824, result);
    }

    @Test
    void testPowerOfTwoWithOne() {
        int result = powerOfTwo(1);
        assertEquals(2, result);
    }

    @Test
    void testPowerOfTwoWithMaxValue() {
        int result = powerOfTwo(31);
        assertEquals(-2147483648, result);
    }
}
