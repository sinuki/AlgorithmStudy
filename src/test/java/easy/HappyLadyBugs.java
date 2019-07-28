package easy;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem?isFullScreen=true
 */
public class HappyLadyBugs {

    private String happyLadybugs(String b) {
        if (b.contains("_")) {
            Map<Integer, Long> map =  b.chars().filter(i -> i != '_').boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return map.values().stream().allMatch(i -> 1L < i) ? "YES" : "NO";
        }

        char[] chars = b.toCharArray();
        char c = chars[0];
        int lettersCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (c == chars[i]) {
                lettersCount++;
            } else if (1 == lettersCount) {
                return "NO";
            } else {
                lettersCount = 1;
                c = chars[i];
            }
        }

        return lettersCount == 1 ? "NO" : "YES";
    }

    @Test
    public void test1() {
        assertEquals("YES", happyLadybugs("RBY_YBR"));
    }

    @Test
    public void test2() {
        assertEquals("NO", happyLadybugs("X_Y__X"));
    }

    @Test
    public void test3() {
        assertEquals("YES", happyLadybugs("__"));
    }

    @Test
    public void test4() {
        assertEquals("YES", happyLadybugs("B_RRBR"));
    }

    @Test
    public void test5() {
        assertEquals("NO", happyLadybugs("A"));
    }

    @Test
    public void test6() {
        assertEquals("YES", happyLadybugs("RRGGBBXX"));
    }

    @Test
    public void test7() {
        assertEquals("NO", happyLadybugs("RRGGBBXY"));
    }
}
