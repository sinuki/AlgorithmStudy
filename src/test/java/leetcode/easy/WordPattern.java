package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordPattern {

    private boolean wordPattern(String pattern, String str) {
        String[] strs = str.split("\\s");
        if (pattern.length() != strs.length) return false;
        HashMap<Object, Integer> mapper = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!Objects.equals(mapper.put(pattern.charAt(i), i), mapper.put(strs[i], i))) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void test2() {
        assertFalse(wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    public void test3() {
        assertFalse(wordPattern("aaaa", "dog cat cat dog"));
    }

    @Test
    public void test4() {
        assertFalse(wordPattern("abba", "dog dog dog dog"));
    }
}
