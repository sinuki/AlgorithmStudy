import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?isFullScreen=true
 */
public class MinimumAbsoluteDifferenceInAnArray {

    private int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.abs(arr[i] - arr[i - 1]);
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }

    @Test
    public void test() {
        assertEquals(2, minimumAbsoluteDifference(new int[] {-2, 2, 4}));
    }
}
