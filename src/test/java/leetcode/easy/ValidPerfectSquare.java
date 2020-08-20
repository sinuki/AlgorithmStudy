package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    private boolean isPerfectSquare(int num) {
        int square = 1;
        int i = 1;
        while (0 < square) {
            if (square == num) return true;
            i++;
            square = i * i;
        }
        return false;
    }

    @Test
    public void test1() {
        Assert.assertTrue(isPerfectSquare(16));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isPerfectSquare(14));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isPerfectSquare(Integer.MAX_VALUE));
    }
}
