package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/maximum-subarray/
 **/
public class MaximumSubArray {

    private int maxSubArray(int[] nums) {
        int temp = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            // 누계를 구하는 처리. 누계를 구하는데 왜 0으로 보정하는 걸까?
            // 만약 최대 누계값이 음수라면 그 음수는 가장 작은 요소 하나여야 하기 때문.
            temp = Math.max(temp, 0) + num;
            // 누계값이 실제 최대값인지 구하는 처리
            maxSum = Math.max(maxSum, temp);
        }

        return maxSum;
    }

    @Test
    public void test1() {
        assertEquals(6, maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test2() {
        assertEquals(-1, maxSubArray(new int[] {-2, -3, -1, -5}));
    }
}
