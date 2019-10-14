package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 **/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)   return nums.length;

        int compareVal = nums[0] - 1;
        int length = 0;

        for (int num : nums) {
            if (compareVal == num)  continue;

            compareVal = num;
            nums[length++] = num;
        }

        return length;
    }

    @Test
    public void 빈배열_테스트() {
        assertEquals(0, removeDuplicates(new int[0]));
    }

    @Test
    public void 일반배열_테스트() {
        assertEquals(3, removeDuplicates(new int[] {1, 1, 2, 3}));
    }
}
