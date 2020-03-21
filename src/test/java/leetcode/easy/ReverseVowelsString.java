package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsString {

    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(s.charAt(start))) start++;
            while (start < end && !vowels.contains(s.charAt(end))) end--;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        assertEquals("holle", reverseVowels("hello"));
    }

    @Test
    public void test2() {
        assertEquals("leotcede", reverseVowels("leetcode"));
    }

    @Test
    public void test3() {
        assertEquals("Aa", reverseVowels("aA"));
    }
}
