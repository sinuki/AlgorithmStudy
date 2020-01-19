package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/
public class BestTimeToBuyAndSellStock2 {

    private int maxProfit(int[] prices) {
        int i = 0;
        int profitSum = 0;
        int peak;
        int valley;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1])  i++;
            peak = prices[i];
            profitSum += peak - valley;
        }
        return profitSum;
    }

    @Test
    public void test1() {
        assertEquals(7, maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void test2() {
        assertEquals(0, maxProfit(new int[] {7, 6, 5, 4, 3, 2}));
    }
}
