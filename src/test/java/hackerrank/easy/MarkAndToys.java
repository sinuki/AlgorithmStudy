package hackerrank.easy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true
 */
public class MarkAndToys {

    private int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;

        for (int price : prices) {
            k -= price;
            if (0 > k)  break;
            count++;
        }

        return count;
    }
}
