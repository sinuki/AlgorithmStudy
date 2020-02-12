package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (0 == nums.length) return;
        int index = 0;
        for (int num : nums) {
            if (0 != num) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] {0, 1, 0, 3, 12};
        moveZeroes(arr);
        assertArrayEquals(new int[] {1, 3, 12, 0, 0}, arr);
    }

    @Test
    public void test2() {
        int[] arr = new int[0];
        moveZeroes(arr);
        assertArrayEquals(new int[0], arr);
    }
}
