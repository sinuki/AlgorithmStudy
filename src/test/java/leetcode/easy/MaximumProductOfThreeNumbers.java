package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers {

    private int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int max2 = nums[nums.length - 1] * nums[0] * nums[1];
        return Math.max(max1, max2);
    }

    @Test
    public void test1() {
        assertEquals(24, maximumProduct(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        assertEquals(720, maximumProduct(new int[] {-4, -3, -2, -1, 60}));
    }
}
