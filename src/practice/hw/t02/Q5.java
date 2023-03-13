package practice.hw.t02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q5 {
    private static String reverse(String str) {
        if (str.length() == 0) return "";
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    @Test
    public void testReverseString() {
        String originalString = "Hello World!";
        String expectedString = "!dlroW olleH";
        String actualString = reverse(originalString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testReverseStringWithEmptyString() {
        String originalString = "";
        String expectedString = "";
        String actualString = reverse(originalString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testReverseStringWithOneCharacter() {
        String originalString = "a";
        String expectedString = "a";
        String actualString = reverse(originalString);
        assertEquals(expectedString, actualString);
    }
}
