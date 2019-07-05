import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem?h_r=internal-search&isFullScreen=true
 */
public class MarsExploration {

    private int marsExploration(String s) {
        int count = 0;
        String sos = "SOS";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3))   count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, marsExploration("SOSSPSSQSSOR"));
    }
}