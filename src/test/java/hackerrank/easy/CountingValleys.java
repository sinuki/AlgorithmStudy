package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_r=internal-search&isFullScreen=true
 */
public class CountingValleys {

    private int countingValleys(int n, String s) {
        int[] steps = s.chars().toArray();
        int count = 0;
        int currentStep = 0;
        boolean flag = false;

        for (int step : steps) {
            currentStep += step == 'D' ? -1 : 1;

            if (currentStep < 0) {
                flag = true;
            } else if (flag) {
                count++;
                flag = false;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(1, countingValleys(8, "UDDDUDUU"));
    }

    @Test
    public void test2() {
        assertEquals(0, countingValleys(7, "UDUD"));
    }
}