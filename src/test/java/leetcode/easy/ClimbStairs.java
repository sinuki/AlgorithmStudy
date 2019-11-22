package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/climbing-stairs/
 **/
public class ClimbStairs {

    private Map<Integer, Integer> storedData = new HashMap<>();

    private int climbStairs(int n) {
        if (n < 3)  return n;

        int data1 = getData(n - 2);
        int data2 = getData(n - 1);
        int sum = data1 + data2;
        storedData.put(n, sum);
        return sum;
    }

    private int getData(int n) {
        int result = storedData.getOrDefault(n, -1);
        if (result == -1) {
            result = climbStairs(n);
            storedData.put(n, result);
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(8, climbStairs(5));
    }
}
