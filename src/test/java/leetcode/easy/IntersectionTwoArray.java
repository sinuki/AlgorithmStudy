package leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionTwoArray {

    private int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Long> mapper = IntStream.of(nums1).boxed().collect(groupingBy(identity(), counting()));
        List<Integer> results = new ArrayList<>();
        for (int num : nums2) {
            long value = mapper.getOrDefault(num, 0L);
            if (0L < value) {
                results.add(num);
                mapper.put(num, --value);
            }
        }
        return results.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    @Test
    public void test1() {
        int[] expected = new int[] {2, 2};
        assertArrayEquals(expected, intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
    }

    @Test
    public void test2() {
        int[] expected = new int[] {4, 9};
        assertArrayEquals(expected, intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
    }
}
