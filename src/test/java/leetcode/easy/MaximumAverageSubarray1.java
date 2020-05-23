package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarray1 {

    private double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (length < i + k) break;
            int sum = 0;
            for (int from = i, to = i + k; from < to; from++) {
                sum += nums[from];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    @Test
    public void test1() {
        Assert.assertEquals(12.75, findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4), 0);
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1.0000, findMaxAverage(new int[] {-1}, 1), 0);
    }
}
