package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 */
public class Kangaroo {

    private String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";

        if (v1 < v2)    return result;
        for (int i = 0; i < 100000; i++) {
            x1 += v1;
            x2 += v2;

            if (x1 == x2) {
                result = "YES";
                break;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals("YES", kangaroo(0, 3, 4, 2));
    }

    @Test
    public void test2() {
        assertEquals("NO", kangaroo(0, 2, 5, 3));
    }
}