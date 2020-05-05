package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence {

    private int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

    @Test
    public void test1() {
        assertEquals(5, findLHS(new int[] {1, 3, 2, 2, 5, 2, 3, 7}));
    }

    @Test
    public void test2() {
        assertEquals(2, findLHS(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        assertEquals(0, findLHS(new int[] {1,3,5,7,9,11,13,15,17}));
    }
}
