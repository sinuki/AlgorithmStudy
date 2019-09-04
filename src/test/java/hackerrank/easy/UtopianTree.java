package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 **/
public class UtopianTree {

    private int utopianTree(int n) {
        int height = 1;
        int spring = 1;

        for (int i = 0; i <= n; i++) {
            if (i == 0) continue;
            if (i == spring) {
                height *= 2;
                spring += 2;
                continue;
            }

            height++;
        }

        return height;
    }

    @Test
    public void test1() {
        assertEquals(1, utopianTree(0));
    }

    @Test
    public void test2() {
        assertEquals(2, utopianTree(1));
    }

    @Test
    public void test3() {
        assertEquals(7, utopianTree(4));
    }
}
