package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {

    private boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 1, limit = nums.length; i < limit; i++) {
            if (!modified && nums[i - 1] > nums[i]) {
                if (0 > i - 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                modified = true;
            }
            if (nums[i - 1] > nums[i]) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(checkPossibility(new int[] {4, 2, 3}));
    }

    @Test
    public void test2() {
        assertFalse(checkPossibility(new int[] {4, 2, 1}));
    }

    @Test
    public void test3() {
        assertFalse(checkPossibility(new int[] {3, 4, 2, 3}));
    }

    @Test
    public void test4() {
        assertTrue(checkPossibility(new int[] {3, 3, 2, 3}));
    }
}
