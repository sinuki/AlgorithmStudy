package leetcode.easy;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRanks {

    private String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] result = new String[nums.length];
        while (!map.isEmpty()) {
            int rank = map.size();
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            int index = entry.getValue();
            switch (rank) {
                case 3:  result[index] = "Bronze Medal"; break;
                case 2:  result[index] = "Silver Medal"; break;
                case 1:  result[index] = "Gold Medal"; break;
                default: result[index] = String.valueOf(rank);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        String[] expected = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        assertArrayEquals(expected, findRelativeRanks(new int[] {5, 4, 3, 2, 1}));
    }

    @Test
    public void test2() {
        String[] expected = {"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"};
        assertArrayEquals(expected, findRelativeRanks(new int[] {10, 3, 8, 9, 4}));
    }
}
