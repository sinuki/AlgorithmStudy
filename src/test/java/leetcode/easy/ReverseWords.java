package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords {

    private String reverseWords(String s) {
        return Arrays.stream(s.split("\\s"))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    @Test
    public void test1() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
    }
}
