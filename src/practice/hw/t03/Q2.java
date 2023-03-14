package practice.hw.t03;

import java.util.Scanner;

/**
 * משחק – ניחוש. המשתמש חושב על מספר בין 1 ל-1000. כתוב  תוכנית המנחשת את  המספר של המשתמש יעילה ככל האפשר .
 * התוכנית מדפיסה מספר בין 0 ל-1000 ומבקשת את המשתמש לבחור באפשרות המתאימה:
 * האם זה המספר שחשבת אליו?
 * האם המספר שחשבת אליו קטן ממספר שהדפסתי?
 * האם המספר שחשבת אליו גדול ממספר שהדפסתי?
 * התשובה של המשתמש היא:  <1 או 2 או 3>
 * המשתמש בוחר באפשרות המתאימה ועונה לתוכנית. המשחק נמשך עד שהמשתמש מקבל את המספר שלו.
 * המשתמש בוחרת
 * במידה והמספר זהה למספר של המשתמש (המשתמש מקליד 1) התוכנית מדפיסה: "!WIN"  והמשחק מסתיים.  בסוף המשחק התוכנית מדפיסה את מספר השלבים שהתבצעו עד ניחוש המספר.
 */
public class Q2 {
    private static void game() {
        int min = 1, max = 1000, input = 0, mid;
        System.out.println("Choose number between " + min + " and " + max);
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        while (!sc.hasNextLine()) ;

        while (input != 1) {
            mid = (max + min) / 2;
            System.out.println("Is your number is: " + mid + "?");
            System.out.println("""
                    1. Yes
                    2. Smaller
                    3. Larger
                    """);
            input = sc.nextInt();
            if (input == 2) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println("WIN!");
        sc.close();
    }

    public static void main(String[] args) {
        game();
    }

}
