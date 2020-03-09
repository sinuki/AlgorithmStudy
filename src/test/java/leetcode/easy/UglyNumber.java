package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    private boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] dividers = new int[] {5, 3, 2};
        for (int divider : dividers) {
            while (num % divider == 0) {
                num /= divider;
            }
        }
        return num == 1;
    }

    @Test
    public void test1() {
        assertTrue(isUgly(6));
    }

    @Test
    public void test2() {
        assertTrue(isUgly(8));
    }

    @Test
    public void test3() {
        assertFalse(isUgly(14));
    }

    @Test
    public void test4() {
        assertFalse(isUgly(-2));
    }
}
