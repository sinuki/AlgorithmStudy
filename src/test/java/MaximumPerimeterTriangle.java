import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
 */
public class MaximumPerimeterTriangle {

    private int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int i = sticks.length - 3;

        while (0 <= i && (sticks[i] + sticks[i + 1] <= sticks[i + 2])) {
            i--;
        }

        return 0 <= i ? new int[] {sticks[i], sticks[i + 1], sticks[i + 2]} : new int[] {-1};
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {-1}, maximumPerimeterTriangle(new int[] {1, 2, 3}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {1, 1, 1}, maximumPerimeterTriangle(new int[] {1, 1, 1, 2, 3, 5}));
    }
}
