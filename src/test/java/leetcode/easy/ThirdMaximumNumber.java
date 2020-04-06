package leetcode.easy;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {

    // 문제에서 요구하는 시간복잡도-O(n)-를 충족하는 방법
    private int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (3 < set.size()) {
                set.remove(set.first());
            }
        }
        return 3 == set.size() ? set.first() : set.last();
    }

    // 시간복잡도 고려하지 않고 풀었던 방법
//    private int thirdMax(int[] nums) {
//        int[] array = IntStream.of(nums).distinct().sorted().toArray();
//        return 2 < array.length ? array[array.length - 3] : array[array.length - 1];
//    }

    @Test
    public void test1() {
        assertEquals(1, thirdMax(new int[] {3, 2, 1}));
    }

    @Test
    public void test2() {
        assertEquals(2, thirdMax(new int[] {1, 2}));
    }

    @Test
    public void test3() {
        assertEquals(1, thirdMax(new int[] {2, 2, 3, 1}));
    }

    @Test
    public void test4() {
        assertEquals(2, thirdMax(new int[] {1, 1, 2}));
    }
}
