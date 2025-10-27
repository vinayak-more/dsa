
import java.util.*;

public class LongestSubStringWithoutRepeatingCharacters {

    /**
     * Finds the longest substring without repeating characters.
     * @param s the input string (only lowercase letters)
     * @return the longest substring without repeating characters
     */
    public String longestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        // Find the start index of the longest substring
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        charSet.clear();
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                right++;
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }
        return s.substring(start, end);
    }

/**
 * Main method to run test cases.
 * @param args command line arguments
 * Sample Input:
7
abcabcbb abc
abc abc
bbbbb b
aab ab
pwwkew wke
a a
abcdefg abcdefg

 */
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters solution = new LongestSubStringWithoutRepeatingCharacters();

        try (Scanner sc = new Scanner(System.in)) {
            int t = Integer.parseInt(sc.next().trim());
            for (int i = 1; i <= t; i++) {
                String input = sc.next().trim();
                String expected = sc.next().trim();
                String actual = solution.longestSubstring(input);
                boolean passed = actual.equals(expected);
                System.out.println("Test case " + i + ":");
                System.out.println("Input: " + input);
                System.out.println("Expected: " + expected);
                System.out.println("Actual: " + actual);
                System.out.println("Result: " + (passed ? "PASSED" : "FAILED"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
