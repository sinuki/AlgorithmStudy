package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseString2 {

    private String reverseStr(String s, int k) {
        if (s.length() < k) return new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        boolean tick = false;
        for (int i = 0, length = s.length(); i < length; i += k) {
            String str = s.substring(i, Math.min(i + k, length));
            sb.append(tick ? str : new StringBuilder(str).reverse());
            tick = !tick;
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

    @Test
    public void test2() {
        assertEquals("gfedcba", reverseStr("abcdefg", 10));
    }
}
