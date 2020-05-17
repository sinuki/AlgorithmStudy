package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanFlowerPlace {

    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && 0 < n; i++) {
            int prev = flowerbed[Math.max(0, i - 1)];
            int next = flowerbed[Math.min(flowerbed.length - 1, i + 1)];
            if (0 == flowerbed[i] && 0 == prev && 0 == next) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return 0 == n;
    }

    @Test
    public void test1() {
        assertTrue(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
    }

    @Test
    public void test2() {
        assertFalse(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
    }
}
