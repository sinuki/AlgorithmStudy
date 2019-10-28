package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/search-insert-position/
 **/
public class SearchInsertPosition {

    private int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    @Test
    public void test1() {
        assertEquals(0, searchInsert(new int[] {1, 2, 4, 5}, 0));
    }

    @Test
    public void test2() {
        assertEquals(1, searchInsert(new int[] {1, 2, 4, 5}, 2));
    }

    @Test
    public void test3() {
        assertEquals(4, searchInsert(new int[] {1, 2, 4, 5}, 6));
    }

}
