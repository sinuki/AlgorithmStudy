import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem?isFullScreen=true
 */
public class ElectronicsShop {

    private int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;

        for (int keyboard : keyboards) {
            int temp = IntStream.of(drives)
                                .map(drive -> keyboard + drive)
                                .filter(sum -> sum <= b)
                                .max()
                                .orElse(-1);
            max = Math.max(temp, max);
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(6, getMoneySpent(new int[] {10, 2, 3}, new int[] {3, 1}, 10));
    }

    @Test
    public void test2() {
        assertEquals(-1, getMoneySpent(new int[] {10, 11, 12}, new int[] {3, 1}, 10));
    }

    @Test
    public void test3() {
        assertEquals(9, getMoneySpent(new int[] {3, 1}, new int[] {5, 2, 8}, 10));
    }
}