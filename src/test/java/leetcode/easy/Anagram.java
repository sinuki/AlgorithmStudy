package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }
        return IntStream.of(alphabets).allMatch(i -> i == 0);
    }

    @Test
    public void test1() {
        assertTrue(isAnagram("anag", "naag"));
    }

    @Test
    public void test2() {
        assertFalse(isAnagram("anaga", "naage"));
    }

}
