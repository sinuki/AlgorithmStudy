package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    private int search(int[] nums, int target) {
        if (0 == nums.length) return -1;
        int targetIndex = Arrays.binarySearch(nums, target);
        return 0 > targetIndex ? -1 : targetIndex;
    }

    @Test
    public void test1() {
        assertEquals(4, search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    public void test2() {
        assertEquals(-1, search(new int[] {-1, 0, 3, 5, 9, 12}, 8));
    }

    @Test
    public void test3() {
        assertEquals(-1, search(new int[0], 8));
    }
}
