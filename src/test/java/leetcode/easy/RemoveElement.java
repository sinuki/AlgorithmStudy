package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-element/
 **/
public class RemoveElement {

    private int removeElement(int[] nums, int val) {
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }

        return length;
    }

    @Test
    public void test1() {
        assertEquals(2, removeElement(new int[] {3, 2, 2, 3}, 3));
    }

    @Test
    public void 빈배열_테스트1() {
        assertEquals(0, removeElement(new int[0], 1));
    }

    @Test
    public void 빈배열_테스트2() {
        assertEquals(0, removeElement(new int[] {3, 3, 3}, 3));
    }

}
