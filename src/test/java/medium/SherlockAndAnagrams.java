package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true
 */
public class SherlockAndAnagrams {

    private int sherlockAndAnagrams(String s) {
        int count = 0;
        int unit = 1;

        while (unit < s.length()) {
            for (int i = 0; i < s.length() - 1; i++) {
                int[] left = s.substring(i, Math.min(i + unit, s.length())).chars().sorted().toArray();

                for (int j = i + 1; j < s.length(); j++) {
                    int[] right = s.substring(j, Math.min(s.length(), j + unit)).chars().sorted().toArray();
                    if (left.length == right.length && Arrays.equals(left, right)) count++;
                }
            }
            unit++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, sherlockAndAnagrams("abba"));
    }

    @Test
    public void test2() {
        assertEquals(0, sherlockAndAnagrams("abcd"));
    }

    @Test
    public void test3() {
        assertEquals(3, sherlockAndAnagrams("ifailuhkqq"));
    }

    @Test
    public void test4() {
        assertEquals(10, sherlockAndAnagrams("kkkk"));
    }

    @Test
    public void test5() {
        assertEquals(399, sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
    }

    @Test
    public void test6() {
        assertEquals(471, sherlockAndAnagrams("gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde"));
    }

    @Test
    public void test7() {
        assertEquals(370, sherlockAndAnagrams("mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw"));
    }

    @Test
    public void test8() {
        assertEquals(403, sherlockAndAnagrams("ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges"));
    }

    @Test
    public void test9() {
        assertEquals(428, sherlockAndAnagrams("zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw"));
    }
}
