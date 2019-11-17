package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/length-of-last-word/
 **/
public class LengthOfLastWord {

    private int lengthOfLastWord(String s) {
        s = s.trim();

        if (s.isEmpty())   return 0;
        return s.length() - s.lastIndexOf(' ') - 1;
    }

    @Test
    public void test1() {
        assertEquals(5, lengthOfLastWord("Hello World"));
    }

    @Test
    public void test2() {
        assertEquals(1, lengthOfLastWord("H "));
    }
}
