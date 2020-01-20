package leetcode.easy;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/majority-element/
 **/
public class MajorityElement {

    private int majorityElement(int[] nums) {
        return IntStream.of(nums).boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get().getKey();

    }

    @Test
    public void test1() {
        assertEquals(3, majorityElement(new int[] {3, 2, 3}));
    }
}
