package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2 {

    private boolean validPalindrome(String s) {
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from++) != s.charAt(to--)) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(validPalindrome("aba"));
    }

    @Test
    public void test2() {
        assertTrue(validPalindrome("abca"));
    }

    @Test
    public void test3() {
        assertTrue(validPalindrome("abbac"));
    }
}
