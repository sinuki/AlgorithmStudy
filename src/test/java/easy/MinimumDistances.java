package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinimumDistances {

    private int minimumDistances(int[] a) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    int distance = Math.abs(j - i);
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    @Test
    public void test1() {
        assertEquals(3, minimumDistances(new int[] {7, 1, 3, 4, 1, 7}));
    }

    @Test
    public void test2() {
        assertEquals(-1, minimumDistances(new int[] {1, 2, 3, 4, 10}));
    }
}
