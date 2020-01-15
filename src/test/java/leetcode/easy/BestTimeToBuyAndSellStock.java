package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BestTimeToBuyAndSellStock
 * author: sinuki
 * createdAt: 2020/01/15
 **/
public class BestTimeToBuyAndSellStock {

    // 내가 푼 방식
    // 시간복잡도 : n^2
    // 공간복잡도 : 1
    private int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (max < diff) {
                    max = diff;
                }
            }
        }
        return max;
    }

    // best solution
    // 시간복잡도 : n
    // 공간복잡도 : 1
//    private int maxProfit(int[] prices) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxPrice = 0;
//        for (int price : prices) {
//            minPrice = Math.min(minPrice, price);
//            maxPrice = Math.max(price - minPrice, maxPrice);
//        }
//        return maxPrice;
//    }

    @Test
    public void test1() {
        assertEquals(5, maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void test2() {
        assertEquals(0, maxProfit(new int[] {7, 6, 5, 4, 3, 2}));
    }
}
