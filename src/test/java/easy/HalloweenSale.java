package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/halloween-sale/problem?isFullScreen=true
 */
public class HalloweenSale {

    private int howManyGames(int p, int d, int m, int s) {
        int count = 0;

        while (p <= s) {
            s -= p;
            p = Math.max(p - d, m);
            count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(6, howManyGames(20, 3, 6, 80));
    }

    @Test
    public void test2() {
        assertEquals(7, howManyGames(20, 3, 6, 85));
    }

    @Test
    public void test3() {
        assertEquals(9917, howManyGames(16, 2, 1, 9981));
    }
}
