package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    private int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for (int num : nums) {
            if (index != num) return index;
            index++;
        }
        return index;
    }

    @Test
    public void test1() {
        assertEquals(2, missingNumber(new int[] {1, 3, 0}));
    }

    @Test
    public void test2() {
        assertEquals(1, missingNumber(new int[] {0}));
    }
}
