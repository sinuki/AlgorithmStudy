package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/flatland-space-stations/problem?isFullScreen=true
 */
public class FlatlandSpaceStations {

    private int flatlandSpaceStations(int n, int[] c) {
        if (n == c.length)  return 0;
        int maximumDistance = 0;

        for (int i = 0; i < n; i++) {
            int temp = Integer.MAX_VALUE;

            for (int el : c) {
                if (i == el) {
                    temp = 0;
                    break;
                }
                temp = Math.min(Math.abs(el - i), temp);
            }

            maximumDistance = Math.max(maximumDistance, temp);
        }

        return maximumDistance;
    }

    @Test
    public void test1() {
        assertEquals(2, flatlandSpaceStations(5, new int[] {0, 4}));
    }
}
