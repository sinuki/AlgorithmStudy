package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower {

    private Integer givenNumber;

    private int guess(int pickedNumber) {
        return givenNumber.compareTo(pickedNumber);
    }

    private int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + ((end - start) / 2);
            int result = guess(mid);
            if (0 == result) return mid;
            if (1 == result) start = mid + 1;
            if (-1 == result) end = mid - 1;
        }
        return start;
    }

    @Test
    public void test1() {
        this.givenNumber = 6;
        Assert.assertEquals(6, guessNumber(10));
    }

    @Test
    public void test2() {
        this.givenNumber = 1;
        Assert.assertEquals(1, guessNumber(3));
    }
}
