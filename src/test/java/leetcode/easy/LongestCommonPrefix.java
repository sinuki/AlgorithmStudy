package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)   return "";

        Arrays.sort(strs, Comparator.comparing(String::length));
        String compareVal = strs[0];

        for (int limit = compareVal.length(); 0 < limit; limit--) {
            String subStr = compareVal.substring(0, limit);
            if (Arrays.stream(strs).allMatch(str -> str.startsWith(subStr))) {
                return subStr;
            }
        }

        return "";
    }

    @Test
    public void test1() {
        assertEquals("fl", longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    @Test
    public void test2() {
        assertEquals("", longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }

    @Test
    public void test3() {
        assertEquals("", longestCommonPrefix(new String[] {""}));
    }

    @Test
    public void test5() {
        assertEquals("b", longestCommonPrefix(new String[] {"bab", "bcc"}));
    }
}
