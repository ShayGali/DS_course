package practice.hw.t03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * כתוב פונקציה שמקבלת שלושה מערכים ממוינים של מחרוזות ומחזירה מערך של מחרוזות המשותפים לשלושה המערכים. השתמש בחיפוש בינארי!
 */
public class Q3 {
    private static String[] intersectionArray(String[] arr1, String[] arr2, String[] arr3) {
        ArrayList<String> res = new ArrayList<>();
        for (String str : arr1) {
            if (isPresent(arr2, str) && isPresent(arr3, str)) {
                res.add(str);
            }
        }

        return res.toArray(new String[]{});
    }

    private static boolean isPresent(String[] arr, String key) {
        int l = 0, r = arr.length - 1, mid, compare;
        while (l <= r) {
            mid = (l + r) / 2;

            compare = key.compareTo(arr[mid]);
            if (compare == 0) return true;
            if (compare < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    @Test
    void testCommonElements() {
        String[] arr1 = {"apple", "banana", "orange", "grape"};
        String[] arr2 = {"banana", "grape", "kiwi", "pear"};
        String[] arr3 = {"banana", "grape", "kiwi", "orange", "strawberry"};
        String[] expected = {"banana", "grape"};
        String[] actual = intersectionArray(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testEmptyArrays() {
        String[] arr1 = {};
        String[] arr2 = {"banana", "kiwi", "grape", "pear"};
        String[] arr3 = {};

        String[] expected = {};
        String[] actual = intersectionArray(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testNoCommonElements() {
        String[] arr1 = {"apple", "banana", "orange"};
        String[] arr2 = {"kiwi", "pear"};
        String[] arr3 = {"strawberry", "watermelon"};

        String[] expected = {};
        String[] actual = intersectionArray(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }


}
