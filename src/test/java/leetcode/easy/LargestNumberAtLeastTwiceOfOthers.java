package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * best solution
     *
     * condition1. 가장 큰 요소는 배열 내에 오직 하나만 존재한다.
     * condition2. 가장 큰 요소는 다른 모든 요소의 최소 2배 이상이어야 한다.
     * 위 조건을 단순화하면 가장 큰 요소는 두 번째로 큰 요소의 2배 이상이면 모든 조건을 만족한다는 뜻이다.
     */
    private int dominantIndex(int[] nums) {
        int largerValue = 0;
        int largestValue = 0;
        int largestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (largestValue < nums[i]) {
                largerValue = largestValue;
                largestValue = nums[i];
                largestIndex = i;
            } else if (largerValue < nums[i]) {
                largerValue = nums[i];
            }
        }
        return largerValue * 2 <= largestValue ? largestIndex : -1;
    }

    // 내가 푼 방법
//    private int dominantIndex(int[] nums) {
//        int largestValue = IntStream.of(nums).max().getAsInt();
//        int largestValueIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == largestValue) {
//                largestValueIndex = i;
//                continue;
//            }
//            if (nums[i] * 2 > largestValue) return -1;
//        }
//        return largestValueIndex;
//    }

    @Test
    public void test1() {
        Assert.assertEquals(1, dominantIndex(new int[] {3, 6, 1, 0}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, dominantIndex(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, dominantIndex(new int[] {0}));
    }
}
