import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/service-lane/problem?isFullScreen=true
 */
public class ServiceLane {

    private int[] serviceLane(int n, int[] widths, int[][] cases) {
        int[] result = new int[cases.length];
        int index = 0;

        for (int[] c : cases) {
            int min = Integer.MAX_VALUE;
            for (int i = c[0]; i <= c[1]; i++) {
                min = Math.min(min, widths[i]);
                result[index] = min;
            }
            result[index++] = min;
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {1, 2, 3, 2, 1}, serviceLane(8, new int[] {2, 3, 1, 2, 3, 2, 3, 3}, new int[][] {{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}}));
    }
}
