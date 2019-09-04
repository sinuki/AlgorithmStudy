package hackerrank.easy;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=true
 */
public class HurdleRace {

    private int hurdleRace(int k, int[] height) {
        int max = IntStream.of(height).max().orElse(0);
        int needPotionCount = max - k;
        return needPotionCount > 0 ? needPotionCount : 0;
    }

    @Test
    public void test1() {
        assertEquals(2, hurdleRace(4, new int[] {1, 6, 3, 5, 2}));
    }
}
