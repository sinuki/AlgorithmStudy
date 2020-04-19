package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    private int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (1 == num) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    @Test
    public void test1() {
        assertEquals(3, findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
    }

    @Test
    public void test2() {
        assertEquals(1, findMaxConsecutiveOnes(new int[] {1}));
    }
}
