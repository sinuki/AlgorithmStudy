package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDisappearedNumbers {

    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> mapper = new HashMap<>();
        for (int num : nums) {
            mapper.putIfAbsent(num, num);
        }
        int index = 1;
        for (int num : nums) {
            if (!mapper.containsKey(index)) {
                results.add(index);
            }
            index++;
        }
        return results;
    }

    @Test
    public void emptyArray() {
        Assert.assertTrue(findDisappearedNumbers(new int[] {}).isEmpty());
    }

    @Test
    public void normalTest1() {
        List<Integer> expected = Arrays.asList(5, 6);
        Assert.assertEquals(expected, findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
