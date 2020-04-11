package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {

    private int compress(char[] chars) {
        int index = 0;
        int count = 1;
        char compareVal = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (compareVal == c) {
                count++;
            } else {
                index = replace(compareVal, chars, index, count);
                compareVal = c;
                count = 1;
            }
        }
        return replace(compareVal, chars, index, count);
    }

    private int replace(char compareVal, char[] chars, int index, int count) {
        int copiedIndex = index;
        chars[copiedIndex++] = compareVal;
        if (1 < count) {
            if (9 < count) {
                chars[copiedIndex++] = (char) ((count / 10) + '0');
            }
            chars[copiedIndex++] = (char) ((count % 10) + '0');
        }
        return copiedIndex;
    }

    @Test
    public void test1() {
        assertEquals(6, compress("aabbccc".toCharArray()));
    }

    @Test
    public void test2() {
        assertEquals(3, compress("aaaaaaaaaa".toCharArray()));
    }
    @Test
    public void test3() {
        assertEquals(1, compress("a".toCharArray()));
    }

    @Test
    public void test4() {
        assertEquals(4, compress("abbbbbbbbbbbb".toCharArray()));
    }
}
