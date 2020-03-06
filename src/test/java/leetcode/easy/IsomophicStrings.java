package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomophicStrings {

    private boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i)] != tArr[t.charAt(i)]) return false;
            sArr[s.charAt(i)] = i + 1;
            tArr[t.charAt(i)] = i + 1;
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(isIsomorphic("egg", "add"));
    }

    @Test
    public void test2() {
        assertFalse(isIsomorphic("foo", "bar"));
    }

    @Test
    public void test3() {
        assertTrue(isIsomorphic("paper", "title"));
    }
}
