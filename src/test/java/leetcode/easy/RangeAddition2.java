package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/range-addition-ii/
 **/
public class RangeAddition2 {

    private int maxCount(int m, int n, int[][] ops) {
        if (null == ops || 0 == ops.length) return m * n;
        int minRowIndex = Integer.MAX_VALUE;
        int minColumnIndex = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minRowIndex = Math.min(minRowIndex, op[0]);
            minColumnIndex = Math.min(minColumnIndex, op[1]);
        }
        return minRowIndex * minColumnIndex;
    }

    @Test
    public void test1() {
        assertEquals(4, maxCount(3, 3, new int[][] {new int[] {2, 2}, new int[] {3, 3}}));
    }

    @Test
    public void test2() {
        assertEquals(9, maxCount(3, 3, null));
    }
}
