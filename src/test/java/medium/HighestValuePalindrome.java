package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/richie-rich/problem?isFullScreen=true
 **/
public class HighestValuePalindrome {

    private String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        boolean[] checkers = new boolean[n];
        // 1. 회문을 만드는 처리
        for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
            char front = chars[i];
            char back = chars[j];

            if (front != back) {
                swap(chars, i, j, front, back, checkers);
                k--;
                if (0 == k) break;
            }
        }
        // 2. 보다 큰 회문을 만드는 처리
        for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
            if (chars[i] == '9' && chars[j] == '9') continue;
            int temp = (checkers[i] || checkers[j]) ? 1 : 2;
            k -= temp;
            if (0 > k) {
                k += temp;
                break;
            }
            chars[i] = '9';
            chars[j] = '9';
        }
        // 3. 주어진 문자열이 홀수일 경우, 정 가운데 문자열은 탐색하지 않으므로 k가 0보다 큰 경우 큰 수로 바꿔준다.
        if (n % 2 == 1 && 0 < k) {
            chars[n / 2] = '9';
            k--;
        }

        return 0 <= k && isPalindrome(chars) ? new String(chars) : "-1";
    }

    private void swap(char[] chars, int frontIndex, int backIndex, char front, char back, boolean[] checkers) {
        if (front < back) {
            chars[frontIndex] = back;
            checkers[frontIndex] = true;
        } else {
            chars[backIndex] = front;
            checkers[backIndex] = true;
        }
    }

    private boolean isPalindrome(char[] chars) {
        int length = chars.length;
        int limit = length / 2;

        for (int i = 0, j = length - 1; i < limit; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }

        return true;
    }

    @Test
    public void test1() {
        assertEquals("3993", highestValuePalindrome("3943", 4, 1));
    }

    @Test
    public void test2() {
        assertEquals("992299", highestValuePalindrome("092282", 6, 3));
    }

    @Test
    public void test3() {
        assertEquals("-1", highestValuePalindrome("0011", 4, 1));
    }

    @Test
    public void test4() {
        assertEquals("9", highestValuePalindrome("1", 1, 5));
    }

    @Test
    public void test5() {
        assertEquals("12921", highestValuePalindrome("12321", 5, 1));
    }

    @Test
    public void test6() {
        assertEquals("992299", highestValuePalindrome("932239", 6, 2));
    }

    @Test
    public void test7() {
        assertEquals("99399", highestValuePalindrome("11331", 5, 4));
    }
}
