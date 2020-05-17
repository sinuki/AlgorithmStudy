package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {

    private String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);
        HashMap<String, Integer> result = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String key = list2[i];
            if (map1.containsKey(key)) {
                int sum = i + map1.get(key);
                if (sum <= minSum) {
                    minSum = sum;
                    result.merge(key, sum, Math::min);
                }
            }
        }
        int min = minSum;
        return result.entrySet().stream()
                .filter(entry -> entry.getValue().equals(min))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    @Test
    public void test1() {
        String[] expected = {"Shogun"};
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Assert.assertArrayEquals(expected, findRestaurant(list1, list2));
    }

    @Test
    public void test2() {
        String[] expected = {"Shogun"};
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        Assert.assertArrayEquals(expected, findRestaurant(list1, list2));
    }
}
