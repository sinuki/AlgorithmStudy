package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/implement-strstr/
 **/
public class ImplementStr {

    private int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        if (needle.isEmpty())   return 0;

        for (int i = 0; i < haystack.length(); i++) {
            int splitLength = i + needle.length();
            if (splitLength > haystack.length())    break;

            String substr = haystack.substring(i, splitLength);
            if (substr.startsWith(needle))  return i;
        }

        return -1;
    }

    @Test
    public void 빈값_테스트() {
        assertEquals(0, strStr("hello", ""));
    }

    @Test
    public void null_테스트1() {
        assertEquals(-1, strStr("hello", null));
    }

    @Test
    public void null_테스트2() {
        assertEquals(-1, strStr(null, "ll"));
    }

    @Test
    public void 정상_테스트() {
        assertEquals(2, strStr("hello", "ll"));
    }
}
