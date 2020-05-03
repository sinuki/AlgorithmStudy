package leetcode.easy;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/distribute-candies/
 */
public class DistributeCandies {

    private int distributeCandies(int[] candies) {
        return Math.min(candies.length / 2, (int) IntStream.of(candies).distinct().count());
    }

    @Test
    public void test1() {
        assertEquals(3, distributeCandies(new int[] {1, 1, 2, 2, 3, 3}));
    }

    @Test
    public void test2() {
        assertEquals(2, distributeCandies(new int[] {1, 1, 2, 3}));
    }

    @Test
    public void test3() {
        assertEquals(1, distributeCandies(new int[] {1, 1, 1, 1}));
    }
}
