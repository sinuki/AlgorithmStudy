package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinuousIncreasingSubsequence {

    private int findLengthOfLCIS(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;
        int longestSequence = 0;
        int tempSequence = 0;
        for (int i = 1, limit = nums.length; i < limit; i++) {
            if (nums[i - 1] < nums[i]) {
                longestSequence = Math.max(longestSequence, ++tempSequence);
            } else {
                tempSequence = 0;
            }
        }
        return longestSequence + 1;
    }

    @Test
    public void test1() {
        assertEquals(3, findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
    }

    @Test
    public void test2() {
        assertEquals(1, findLengthOfLCIS(new int[] {2, 2, 2, 2}));
    }

    @Test
    public void test3() {
        assertEquals(0, findLengthOfLCIS(new int[0]));
    }
}
