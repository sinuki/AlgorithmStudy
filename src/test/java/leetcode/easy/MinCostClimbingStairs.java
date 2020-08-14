package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    private int minCostClimbingStairs(int[] cost) {
        int twoPrevious = cost[0];
        int onePrevious = cost[1];
        int current;
        for (int i = 2; i < cost.length; i++) {
            current = Math.min(twoPrevious, onePrevious) + cost[i];
            twoPrevious = onePrevious;
            onePrevious = current;
        }
        return Math.min(onePrevious, twoPrevious);
    }

    @Test
    public void test1() {
        Assert.assertEquals(15, minCostClimbingStairs(new int[] {10, 15, 20}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, minCostClimbingStairs(new int[] {0, 1, 2, 2}));
    }
}
