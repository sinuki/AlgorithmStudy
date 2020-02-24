package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        return nums.length != IntStream.of(nums).distinct().toArray().length;
    }

    @Test
    public void test1() {
        assertTrue(containsDuplicate(new int[] {1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        assertFalse(containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        assertTrue(containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
