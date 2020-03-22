package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {

    private Set<Integer> set = new HashSet<>(Arrays.asList(1 , 4 , 16 , 64 , 256 , 1024 , 4096 , 16384 , 65536 , 262144 , 1048576 , 4194304 , 16777216 , 67108864 , 268435456 , 1073741824));
    public boolean isPowerOfFour(int num) {
        return set.contains(num);
    }

    @Test
    public void maxTest() {
        assertFalse(isPowerOfFour(Integer.MAX_VALUE));
    }

    @Test
    public void minTest() {
        assertFalse(isPowerOfFour(0));
    }

    @Test
    public void test1() {
        assertTrue(isPowerOfFour(16));
    }

    @Test
    public void test2() {
        assertFalse(isPowerOfFour(5));
    }
}
