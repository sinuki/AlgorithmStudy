package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

    private int arrangeCoins(int n) {
        int index = 1;
        while (index <= n) {
            n -= index++;
        }
        return index - 1;
    }

    @Test
    public void test1() {
        assertEquals(2, arrangeCoins(5));
    }

    @Test
    public void test2() {
        assertEquals(3, arrangeCoins(8));
    }

    @Test
    public void test3() {
        assertEquals(65535, arrangeCoins(Integer.MAX_VALUE));
    }
}
