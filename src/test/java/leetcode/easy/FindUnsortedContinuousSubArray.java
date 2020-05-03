package leetcode.easy;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class FindUnsortedContinuousSubArray {

    private int findUnsortedSubarray(int[] nums) {
        int[] sorted = IntStream.of(nums).sorted().toArray();
        int startIndex = 0;
        while (startIndex < nums.length && nums[startIndex] == sorted[startIndex]) {
            startIndex++;
        }
        int endIndex = nums.length - 1;
        while (startIndex < endIndex && nums[endIndex] == sorted[endIndex]) {
            endIndex--;
        }
        return startIndex == endIndex ? 0 : endIndex - startIndex + 1;
    }

    @Test
    public void test1() {
        assertEquals(5, findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
    }

    @Test
    public void test2() {
        assertEquals(0, findUnsortedSubarray(new int[] {2, 4, 6, 8, 9, 10, 15}));
    }

}
