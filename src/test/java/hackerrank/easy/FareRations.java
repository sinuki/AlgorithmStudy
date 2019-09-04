package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/fair-rations/problem?isFullScreen=true
 */
public class FareRations {

    private String fairRations(int[] B) {
        int breadCount = 0;

        for (int i = 0; i < B.length; i++) {
            if (B[i] % 2 != 0) {
                B[i]++;
                breadCount++;

                if (i + 1 < B.length) {
                    B[i + 1]++;
                    breadCount++;
                }
            }
        }

        return breadCount % 2 == 0 ? String.valueOf(breadCount) : "NO";
    }

    @Test
    public void test1() {
        assertEquals("4", fairRations(new int[] {2,3,4,5,6}));
    }

    @Test
    public void test2() {
        assertEquals("NO", fairRations(new int[] {1,2}));
    }
}
