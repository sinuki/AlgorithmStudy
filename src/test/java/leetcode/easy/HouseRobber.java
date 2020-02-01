package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/house-robber/
 **/
public class HouseRobber {

    private int[] mapper;

    public int rob(int[] nums) {
        mapper = new int[nums.length];
        Arrays.fill(mapper, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int index) {
        if (index < 0) return 0;
        if (mapper[index] > -1) return mapper[index];
        int result = Math.max(rob(nums, index - 2) + nums[index], rob(nums, index - 1));
        mapper[index] = result;
        return result;
    }

    @Test
    public void test1() {
        assertEquals(4, rob(new int[] {1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        assertEquals(6, rob(new int[] {1, 1, 3, 5}));
    }
}
