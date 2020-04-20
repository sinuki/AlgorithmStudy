package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            boolean found = false;
            for (int i = map.get(num) + 1; i < nums2.length; i++) {
                if (num < nums2[i]) {
                    result[index++] = nums2[i];
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[index++] = -1;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] expected = new int[] {-1, 3, -1};
        assertArrayEquals(expected, nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}));
    }

    @Test
    public void test2() {
        int[] expected = new int[] {3, -1};
        assertArrayEquals(expected, nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        int[] expected = new int[] {-1, 2, 3};
        assertArrayEquals(expected, nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 2, 3, 4}));
    }
}
