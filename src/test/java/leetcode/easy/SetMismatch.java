package leetcode.easy;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

    // 다른 사람 풀이법 - 전체 시간 복잡도는 O(n)으로 같지만 상수시간이 더 작다 -
    private int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int duplicate = 0;
        int n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int num : nums) {
            if (set.contains(num)) duplicate = num;
            sum -= num;
            set.add(num);
        }
        return new int[] {duplicate, (int) sum + duplicate};
    }

    // 내가 푼 방법
//    private int[] findErrorNums(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.merge(num, 1, Integer::sum);
//        }
//        int[] result = new int[2];
//        for (int i = 0, length = nums.length; i < length; i++) {
//            int index = i + 1;
//            boolean isContains = map.containsKey(index);
//            if (isContains && 1 < map.getOrDefault(index, 1)) result[0] = index;
//            if (!isContains) result[1] = index;
//        }
//        return result;
//    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {2, 3}, findErrorNums(new int[] {1, 2, 2, 4}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {1, 2}, findErrorNums(new int[] {1, 1}));
    }
}
