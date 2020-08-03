package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {

    private char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (target < letter) return letter;
        }
        return letters[0];
    }

    @Test
    public void test1() {
        Assert.assertEquals('c', nextGreatestLetter("cfj".toCharArray(), 'a'));
    }

    @Test
    public void test2() {
        Assert.assertEquals('c', nextGreatestLetter("cfj".toCharArray(), 'k'));
    }
}
