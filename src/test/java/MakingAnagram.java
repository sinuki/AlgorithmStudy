import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MakingAnagram {

    private int makingAnagrams(String s1, String s2) {
        int[] lettersCount = new int[26];
        for (char c : s1.toCharArray()) lettersCount[c - 97]++;
        for (char c : s2.toCharArray()) lettersCount[c - 97]--;
        return IntStream.of(lettersCount).map(Math::abs).sum();
    }

    @Test
    public void test1() {
        assertEquals(4, makingAnagrams("cde", "abc"));
    }

    @Test
    public void test2() {
        assertEquals(0, makingAnagrams("bacdc", "dcbac"));
    }

    @Test
    public void test3() {
        assertEquals(2, makingAnagrams("bacdc", "dcbad"));
    }
}
