package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class KdiffPairsInAnArray {

    // 시간복잡도 O(n)으로 푼 방법
    private int findPairs(int[] nums, int k) {
        if (0 > k) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num -> map.merge(num, 1, Integer::sum));
        return (int) map.entrySet().stream()
                .filter(entry -> {
                    boolean isZeroDiff = 0 == k;
                    if (isZeroDiff && 1 < entry.getValue()) return true;
                    return !isZeroDiff && map.containsKey(entry.getKey() + k);
                })
                .count();
    }

    // 처음에 푼 방법. 시간복잡도 O(n^2)
//    private int findPairs(int[] nums, int k) {
//        int count = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            int num1 = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                int num2 = nums[j];
//                int min = Math.min(num1, num2);
//                int max = Math.max(num1, num2);
//                int diff = max - min;
//                if (diff == k && !map.containsKey(min)) {
//                    map.put(min, max);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    @Test
    public void test1() {
        assertEquals(2, findPairs(new int[] {3, 1, 4, 1, 5}, 2));
    }

    @Test
    public void test2() {
        assertEquals(4, findPairs(new int[] {1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void test3() {
        assertEquals(1, findPairs(new int[] {1, 3, 1, 5, 4}, 0));
    }

    @Test
    public void test4() {
        assertEquals(0, findPairs(new int[] {1, 2, 3, 4, 5}, -1));
    }
}
