package solution;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 х 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class PalindromicNumbers {
    public final static int MAX_THREE_DIGIT_NUMBER = 999;
    public final static int MIN_THREE_DIGIT_NUMBER = 100;

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("Max palindrome: " + findMajorPalindromicNumber());

        long endTime = System.nanoTime();
        System.out.println("Spent time: " + (endTime - startTime) + " ns");
    }

    public static boolean isPalindromic(String str) {
        if (str.isEmpty()) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            str = str.substring(1, str.length() - 1);
        } else
            return false;

        return isPalindromic(str);
    }

    public static int findMajorPalindromicNumber() {
        int result = 0;

        for (int i = MAX_THREE_DIGIT_NUMBER; i > MIN_THREE_DIGIT_NUMBER; i--) {
            for (int j = MAX_THREE_DIGIT_NUMBER; j > MIN_THREE_DIGIT_NUMBER; j--) {
                int value = i * j;
                if (value < result) {
                    break;
                }
                if (isPalindromic(String.valueOf(value))) {
                    result = value;
                }
            }
        }

        return result;
    }
}