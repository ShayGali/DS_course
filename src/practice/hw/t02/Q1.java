package practice.hw.t02;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Q1 {
    private static int sum(int a, int b) {
        if (b == 0) return a;
        return sum(a, b - 1) + 1;
    }

    private static int subtract(int a, int b) {
        if (b == 0) return a;
        return subtract(a, b - 1) - 1;
    }

    private static int multiply(int a, int b) {
        if (b == 0) return 0;
        if (b == 1) return a;
        return multiply(a, b - 1) + a;
    }

    private static int division(int a, int b) {
        if (b == 0) throw new ArithmeticException("cant dived by 0");
        if (a < b) return 0;
        return division(a - b, b) + 1;
    }

    private static int remainder(int a, int b) {
        if (b == 0) throw new ArithmeticException("cant dived by 0");
        if (a < b) return a;
        return remainder(a - b, b);
    }

    @Nested
    class SumTest {

        @Test
        void testSumWithPositiveNumbers() {
            int result = sum(2, 3);
            assertEquals(5, result);
        }

        @Test
        void testSumWithZero() {
            int result = sum(5, 0);
            assertEquals(5, result);
        }

        @Test
        void testSumWithOneNegativeNumber() {
            int result = sum(-5, 3);
            assertEquals(-2, result);
        }

    }


    @Nested
    class SubtractTest {

        @Test
        void testSubtractWithPositiveNumbers() {
            int result = subtract(10, 3);
            assertEquals(7, result);
        }

        @Test
        void testSubtractWithZero() {
            int result = subtract(5, 0);
            assertEquals(5, result);
        }

        @Test
        void testSubtractWithOneNegativeNumber() {
            int result = subtract(-5, 3);
            assertEquals(-8, result);
        }

        @Test
        void testSubtractWithEqualNumbers() {
            int result = subtract(4, 4);
            assertEquals(0, result);
        }
    }


    @Nested
    class MultiplyTest {

        @Test
        void testMultiplyWithPositiveNumbers() {
            int result = multiply(2, 3);
            assertEquals(6, result);
        }

        @Test
        void testMultiplyWithZero() {
            int result = multiply(5, 0);
            assertEquals(0, result);
        }

        @Test
        void testMultiplyWithOne() {
            int result = multiply(5, 1);
            assertEquals(5, result);
        }

        @Test
        void testMultiplyWithOneNegativeNumber() {
            int result = multiply(-5, 3);
            assertEquals(-15, result);
        }
    }


    @Nested
    class DivisionTest {

        @Test
        void testDivisionWithPositiveNumbers() {
            int result = division(10, 2);
            assertEquals(5, result);
        }

        @Test
        void testDivisionWithZeroDenominator() {
            assertThrows(ArithmeticException.class, () -> division(5, 0));
        }

        @Test
        void testDivisionWithOneNumerator() {
            int result = division(6, 1);
            assertEquals(6, result);
        }

        @Test
        void testDivisionWithNumeratorEqualToDenominator() {
            int result = division(8, 8);
            assertEquals(1, result);
        }

        @Test
        void testDivisionWithNumeratorLessThanDenominator() {
            int result = division(5, 10);
            assertEquals(0, result);
        }
    }

    @Nested
    class RemainderTest {

        @Test
        void testRemainderWithPositiveNumbers() {
            int result = remainder(10, 3);
            assertEquals(1, result);
        }

        @Test
        void testRemainderWithZeroDenominator() {
            assertThrows(ArithmeticException.class, () -> remainder(5, 0));
        }

        @Test
        void testRemainderWithOneNumerator() {
            int result = remainder(6, 1);
            assertEquals(0, result);
        }

        @Test
        void testRemainderWithNumeratorEqualToDenominator() {
            int result = remainder(8, 8);
            assertEquals(0, result);
        }

        @Test
        void testRemainderWithNumeratorLessThanDenominator() {
            int result = remainder(5, 10);
            assertEquals(5, result);
        }
    }

}
