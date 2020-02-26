package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    private void reverseString(char[] s) {
        if (2 > s.length) return;
        int size = s.length / 2;
        for (int i = 0, j = s.length - 1; i < size; i++, j--) {
            char left = s[i];
            char right = s[j];
            s[i] = right;
            s[j] = left;
        }
    }

    @Test
    public void normalTest() {
        char[] expected = new char[] {'o', 'x'};
        reverseString(expected);
        Assert.assertArrayEquals(expected, new char[] {'x', 'o'});
    }

    @Test
    public void oneLetterTest() {
        char[] expected = new char[] {'o'};
        reverseString(expected);
        Assert.assertArrayEquals(expected, new char[] {'o'});
    }

    @Test
    public void emptyTest() {
        char[] expected = new char[0];
        reverseString(expected);
        Assert.assertArrayEquals(expected, new char[0]);
    }

}
