package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {

    private int countPrimes(int n) {
        boolean[] checker = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!checker[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    checker[i * j] = true;
                }
            }
        }
        return count;
    }

    @Test
    public void empty() {
        assertEquals(0, countPrimes(2));
    }

    @Test
    public void normal() {
        assertEquals(4, countPrimes(10));
    }
}
