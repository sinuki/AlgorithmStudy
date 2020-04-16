package leetcode.easy;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int patternLength = s.length() / 2;
        while (0 < patternLength) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0, length = s.length(); i < length; i += patternLength) {
                if (0 == i && length % patternLength != 0) break;
                set.add(s.substring(i, Math.min(i + patternLength, length)));
                if (1 < set.size()) break;
            }
            if (1 == set.size()) return true;
            patternLength--;
        }
        return false;
    }

    @Test
    public void test1() {
        assertTrue(repeatedSubstringPattern("abab"));
    }

    @Test
    public void test2() {
        assertFalse(repeatedSubstringPattern("aba"));
    }

    @Test
    public void test3() {
        assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }
}
