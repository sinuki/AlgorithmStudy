package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/perfect-number/
 */
public class PerfectNumber {

    private boolean checkPerfectNumber(int num) {
        if (2 > num) return false;
        int sqrt = (int) Math.sqrt(num);
        int sum = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (0 == num % i) {
                sum += i;
                sum += (1 == i || sqrt == num) ? 0 : (num / i);
            }
        }
        return num == sum;
    }

    @Test
    public void test1() {
        assertTrue(checkPerfectNumber(28));
    }

    @Test
    public void test2() {
        assertFalse(checkPerfectNumber(2));
    }

    @Test
    public void test3() {
        assertFalse(checkPerfectNumber(1));
    }
}
