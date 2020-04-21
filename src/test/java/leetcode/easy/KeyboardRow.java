package leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/keyboard-row/
 */
public class KeyboardRow {
    List<Set<Integer>> list = Arrays.asList(
        "qwertyuiop".chars().boxed().collect(Collectors.toSet()),
        "asdfghjkl".chars().boxed().collect(Collectors.toSet()),
        "zxcvbnm".chars().boxed().collect(Collectors.toSet())
    );

    private String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (Set<Integer> set : list) {
                if (word.toLowerCase().chars().allMatch(set::contains)) {
                    result.add(word);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    @Test
    public void test1() {
        String[] expected = {"Alaska", "Dad"};
        assertArrayEquals(expected, findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"}));
    }
}
