package hackerrank.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true
 */
public class SockMerchant {

    private int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int color : ar) {
            map.merge(color, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        return map.values().stream().mapToInt(value -> value / 2).sum();
    }

    @Test
    public void test1() {
        assertEquals(3, sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

}