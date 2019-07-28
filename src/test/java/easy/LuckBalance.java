package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem?isFullScreen=true
 */
public class LuckBalance {

    private int luckBalance(int k, int[][] contests) {
        int luck = 0;
        List<Integer> importants = new ArrayList<>();

        for (int[] contest : contests) {
            luck += contest[0];

            if (1 == contest[1])    importants.add(contest[0]);
        }

        return luck - (importants.size() - k <= 0 ? 0 : importants.stream().sorted().limit(importants.size() - k).mapToInt(i -> i).sum() * 2);
    }

    @Test
    public void test1() {
        assertEquals(29, luckBalance(3, new int[][] {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10,0},  {5, 0}}));
    }

    @Test
    public void test2() {
        assertEquals(42, luckBalance(5, new int[][] {{13, 1}, {10, 1}, {9 ,1}, {8 ,1}, {13, 1}, {12, 1}, {18, 1}, {13, 1}}));
    }
}
