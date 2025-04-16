package academy.javapro.lab10;

public class Lab10 {

    /**
     * Exercise 1: Factorial
     * Returns the factorial of n (n!)
     *
     * @param n - A positive integer
     * @return The factorial of n
     */
    public static int factorial(int n) {
        // Base case: factorial of 1 is 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    /**
     * Exercise 2: Counting Ears
     * Counts the total number of ears for n rabbits
     *
     * @param n - Number of rabbits
     * @return Total number of ears
     */
    public static int countEars(int n) {
        // Base case: no rabbits means no ears
        if (n == 0) {
            return 0;
        }
        // Recursive case: 2 ears for this rabbit + ears for the rest
        return 2 + countEars(n - 1);
    }

    /**
     * Exercise 3: Fibonacci Sequence
     * Returns the nth Fibonacci number
     *
     * @param n - Position in the sequence (0-indexed)
     * @return The nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // Base cases: first two numbers in the sequence
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case: sum of the previous two numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Level 2: Recursive Number Processing

    /**
     * Exercise 4: Special Ear Count
     * Counts ears with a special pattern: odd-numbered rabbits have 2 ears,
     * even-numbered rabbits have 3 ears
     *
     * @param n - Number of rabbits
     * @return Total number of ears
     */
    public static int specialEars(int n) {
        // Base case: no rabbits means no ears
        if (n == 0) {
            return 0;
        }
        // Recursive case with pattern: odd rabbits (2 ears), even rabbits (3 ears)
        if (n % 2 == 0) {
            return 3 + specialEars(n - 1);
        } else {
            return 2 + specialEars(n - 1);
        }
    }

    /**
     * Exercise 5: Triangle Blocks
     * Calculates the total number of blocks in a triangle with n rows
     *
     * @param n - Number of rows
     * @return Total number of blocks
     */
    public static int triangleBlocks(int n) {
        // Base case: no rows means no blocks
        if (n == 0) {
            return 0;
        }
        // Recursive case: blocks in this row + blocks in the rows above
        return n + triangleBlocks(n - 1);
    }

    /**
     * Exercise 6: Digital Sum
     * Calculates the sum of all digits in a non-negative integer
     *
     * @param n - A non-negative integer
     * @return Sum of all digits
     */
    public static int sumDigits(int n) {
        // Base case: single digit number
        if (n < 10) {
            return n;
        }
        // Recursive case: rightmost digit + sum of the rest
        return (n % 10) + sumDigits(n / 10);
    }

    // Level 3: Digit Counting Recursively

    /**
     * Exercise 7: Counting Sevens
     * Counts occurrences of the digit 7 in a number
     *
     * @param n - A non-negative integer
     * @return Count of digit 7
     */
    public static int countSevens(int n) {
        // Base case: no more digits
        if (n == 0) {
            return 0;
        }
        // Check if rightmost digit is 7
        if (n % 10 == 7) {
            return 1 + countSevens(n / 10);
        }
        // Otherwise, continue with the rest
        return countSevens(n / 10);
    }

    /**
     * Exercise 8: Complex Digit Counting
     * Counts occurrences of 8 with special rule: an 8 with another 8 to its left counts double
     *
     * @param n - A non-negative integer
     * @return Weighted count of digit 8
     */
    public static int countEights(int n) {
        // Base case: no more digits
        if (n == 0) {
            return 0;
        }
        // Get the rightmost and second-rightmost digits
        int rightDigit = n % 10;
        int secondRightDigit = (n / 10) % 10;

        // Check special case: 8 preceded by another 8
        if (rightDigit == 8 && secondRightDigit == 8) {
            return 2 + countEights(n / 10);
        }
        // Normal case: just a regular 8
        if (rightDigit == 8) {
            return 1 + countEights(n / 10);
        }
        // No 8 in the rightmost position
        return countEights(n / 10);
    }

    // Level 4: String Recursion Basics

    /**
     * Exercise 9: Substring Counting
     * Counts occurrences of "hi" in a string
     *
     * @param str - Input string
     * @return Count of "hi" occurrences
     */
    public static int countHi(String str) {
        // Base case: string too short to contain "hi"
        if (str.length() < 2) {
            return 0;
        }
        // Check if the first two characters are "hi"
        if (str.startsWith("hi")) {
            return 1 + countHi(str.substring(2));
        }
        // Otherwise, check the next character
        return countHi(str.substring(1));
    }

    /**
     * Exercise 10: Character Replacement
     * Replaces all 'x' with 'y' in a string
     *
     * @param str - Input string
     * @return String with 'x' replaced by 'y'
     */
    public static String replaceChar(String str) {
        // Base case: empty string
        if (str.length() == 0) {
            return "";
        }
        // Replace 'x' with 'y' if first character is 'x'
        if (str.charAt(0) == 'x') {
            return "y" + replaceChar(str.substring(1));
        }
        // Otherwise, keep the first character and process the rest
        return str.charAt(0) + replaceChar(str.substring(1));
    }

    /**
     * Exercise 11: Character Removal
     * Removes all occurrences of 'x' from a string
     *
     * @param str - Input string
     * @return String with 'x' removed
     */
    public static String removeChar(String str) {
        // Base case: empty string
        if (str.length() == 0) {
            return "";
        }
        // Skip 'x' characters
        if (str.charAt(0) == 'x') {
            return removeChar(str.substring(1));
        }
        // Otherwise, keep the first character
        return str.charAt(0) + removeChar(str.substring(1));
    }

    // Level 5: Advanced String Recursion

    /**
     * Exercise 12: Adjacent Character Marking
     * Places '*' between identical adjacent characters
     *
     * @param str - Input string
     * @return String with '*' between identical adjacent chars
     */
    public static String markPairs(String str) {
        // Base case: single character or empty string
        if (str.length() <= 1) {
            return str;
        }
        // Check if first and second characters are identical
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + markPairs(str.substring(1));
        }
        // Otherwise, just keep the first character
        return str.charAt(0) + markPairs(str.substring(1));
    }

    /**
     * Exercise 13: String Deduplication
     * Removes duplicate adjacent characters
     *
     * @param str - Input string
     * @return String with duplicates removed
     */
    public static String deduplicate(String str) {
        // Base case: single character or empty string
        if (str.length() == 0) {
            return "";
        }
        // Remove duplicate adjacent characters
        if (str.length() > 1 && str.charAt(0) == str.charAt(1)) {
            return deduplicate(str.substring(1));
        }
        // Otherwise, keep the first character
        return str.charAt(0) + deduplicate(str.substring(1));
    }

    // Level 6: Complex Recursive Problems

    /**
     * Exercise 14: Conditional Substring Counting
     * Counts "hi" occurrences, but not when preceded by 'x'
     *
     * @param str - Input string
     * @return Count of valid "hi" occurrences
     */
    public static int countHiSpecial(String str) {
        // Base case: string too short
        if (str.length() < 2) {
            return 0;
        }
        // If "hi" is preceded by 'x', skip it
        if (str.startsWith("hi") && (str.length() == 2 || str.charAt(0) != 'x')) {
            return 1 + countHiSpecial(str.substring(2));
        }
        // Otherwise, continue with the next characters
        return countHiSpecial(str.substring(1));
    }

    public static void main(String[] args) {
        // Testing all exercises
        System.out.println("Factorial of 5: " + factorial(5)); // 120
        System.out.println("Count ears for 5 rabbits: " + countEars(5)); // 10
        System.out.println("Fibonacci of 6: " + fibonacci(6)); // 8
        System.out.println("Special ears for 5 rabbits: " + specialEars(5)); // 13
        System.out.println("Triangle blocks for 3 rows: " + triangleBlocks(3)); // 6
        System.out.println("Sum of digits in 12345: " + sumDigits(12345)); // 15
        System.out.println("Count sevens in 177717: " + countSevens(177717)); // 4
        System.out.println("Count eights in 883788: " + countEights(883788)); // 4
        System.out.println("Count 'hi' in 'hihihi': " + countHi("hihihi")); // 3
        System.out.println("Replace 'x' with 'y' in 'xoxo': " + replaceChar("xoxo")); // "yoyo"
        System.out.println("Remove 'x' from 'xxoxo': " + removeChar("xxoxo")); // "oo"
        System.out.println("Mark pairs in 'aabbcc': " + markPairs("aabbcc")); // "a*b*b*c*c"
        System.out.println("Deduplicate 'aabbcc': " + deduplicate("aabbcc")); // "abc"
        System.out.println("Count 'hi' not preceded by 'x' in 'xhixhi': " + countHiSpecial("xhixhi")); // 1
    }
}

     
     
 
 
      
    
