import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem?h_r=internal-search&isFullScreen=true
 */
public class AppleAndOrange {

    private int[] solve(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int[] result = new int[2];

        for (int apple : apples) {
            int temp = a + apple;
            if (temp >= s && temp <= t) {
                result[0]++;
            }
        }

        for (int orange : oranges) {
            int temp = b + orange;
            if (temp >= s && temp <= t) {
                result[1]++;
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {1,  1}, solve(7, 11, 5, 15, new int[] {-2, 2, 1}, new int[] {5, -6}));
    }

}
