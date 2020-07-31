package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class LongestWordInDictionary {

    private String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        String answer = "";
        for (String word : words) {
            if (1 == word.length() || set.contains(word.substring(0, word.length() - 1))) {
                answer = word.length() > answer.length() ? word : answer;
                set.add(word);
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertEquals("world", longestWord(new String[] {"w", "wo", "wor", "worl", "world"}));
    }

    @Test
    public void test2() {
        assertEquals("apple", longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    @Test
    public void test3() {
        assertEquals("eyj", longestWord(new String[] {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));
    }
}
