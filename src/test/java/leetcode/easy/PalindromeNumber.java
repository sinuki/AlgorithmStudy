package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/palindrome-number/
 **/
public class PalindromeNumber {

    private boolean isPalindrome(int x) {
        String number = String.valueOf(x);

        for (int i = 0, j = number.length() - 1, length = number.length() / 2; i < length; i++, j--) {
            if (number.charAt(i) != number.charAt(j))   return false;
        }

        return true;
    }

    @Test
    public void 회문_짝수길이_테스트() {
        assertTrue(isPalindrome(1221));
    }

    @Test
    public void 회문_홀수길이_테스트() {
        assertTrue(isPalindrome(121));
    }
}
