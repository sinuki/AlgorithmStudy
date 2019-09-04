package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/two-sum/
 **/
public class TwoSum {

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];

            if (map.containsKey(remain)) {
                return new int[] {map.get(remain), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {0, 1}, twoSum(new int[] {2, 7, 11, 15}, 9));
    }
}
