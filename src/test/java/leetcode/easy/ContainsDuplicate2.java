package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicate2 {

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mapper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapper.containsKey(nums[i]) && i - mapper.get(nums[i]) <= k) {
                return true;
            }
            mapper.put(nums[i], i);
        }
        return false;
    }

    @Test
    public void test1() {
        assertTrue(containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
    }

    @Test
    public void test2() {
        assertTrue(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
    }

    @Test
    public void test3() {
        assertFalse(containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }
}
