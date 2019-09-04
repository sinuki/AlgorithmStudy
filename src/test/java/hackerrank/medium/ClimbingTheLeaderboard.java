package hackerrank.medium;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
 **/
public class ClimbingTheLeaderboard {

    private int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] uniqueScores = IntStream.of(scores).distinct().toArray();
        int[] aliceRanking = new int[alice.length];

        for (int i = 0; i < alice.length; i++) {
            aliceRanking[i] = getRank(uniqueScores, alice[i]);
        }

        return aliceRanking;
    }

    private int getRank(int[] uniqueScores, int key) {
        int low = 0;
        int high = uniqueScores.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key < uniqueScores[mid]) {
                low = mid + 1;
            } else if (key > uniqueScores[mid]) {
                high = mid - 1;
            } else {
                return mid + 1;
            }
        }
        mid = IntStream.of(low, high).filter(i -> i > -1).min().orElse(0);
        return key < uniqueScores[mid] ? mid + 2 : mid + 1;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {6, 4, 2, 1}, climbingLeaderboard(new int[] {100, 100, 50, 40, 40, 20, 10}, new int[] {5, 25, 50, 120}));
    }
}
