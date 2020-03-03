package leetcode.easy;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInString {

    static class IndexAndCount {
        int index;
        int count;
        IndexAndCount(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private int firstUniqChar(String s) {
        Map<Character, IndexAndCount> checker = new LinkedHashMap<>();
        int index = 0;
        for (char letter : s.toCharArray()) {
            if (checker.containsKey(letter)) {
                checker.get(letter).count++;
            } else {
                checker.put(letter, new IndexAndCount(index, 1));
            }
            index++;
        }
        return checker.values().stream()
                .filter(indexAndCount -> indexAndCount.count == 1)
                .map(indexAndCount -> indexAndCount.index)
                .findFirst()
                .orElse(-1);
    }

    @Test
    public void test1() {
        assertEquals(0, firstUniqChar("leetcode"));
    }

    @Test
    public void test2() {
        assertEquals(2, firstUniqChar("loveleetcode"));
    }

    @Test
    public void test3() {
        assertEquals(8, firstUniqChar("dddccdbba"));
    }

    @Test
    public void notFoundTest() {
        assertEquals(-1, firstUniqChar("aabbcc"));
    }
}
