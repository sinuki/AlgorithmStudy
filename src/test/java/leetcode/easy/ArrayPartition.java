package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartition {

    private int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = nums[0];
        for (int i = 2; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void test1() {
        assertEquals(4, arrayPairSum(new int[] {1, 3, 2, 4}));
    }
}
