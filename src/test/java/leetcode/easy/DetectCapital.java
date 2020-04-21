package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {

    private boolean detectCapitalUse(String word) {
        if (word.isEmpty()) return false;
        char[] chars = word.toCharArray();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        for (char c : chars) {
            if (Character.isUpperCase(c)) upperCaseCount++;
            if (Character.isLowerCase(c)) lowerCaseCount++;
        }
        int wordLength = word.length();
        return (wordLength == upperCaseCount)
                || (wordLength == lowerCaseCount)
                || (isFirstCapital && wordLength - 1 == lowerCaseCount);
    }

    @Test
    public void test1() {
        assertTrue(detectCapitalUse("USA"));
    }

    @Test
    public void test2() {
        assertFalse(detectCapitalUse("FlaG"));
    }

    @Test
    public void test3() {
        assertTrue(detectCapitalUse("Google"));
    }
}
