package easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/grid-challenge/problem?isFullScreen=true
 */
public class GridChallenge {

    private String gridChallenge(String[] grid) {
        int columnLength = grid[0].length();
        int[][] squares = new int[grid.length][columnLength];
        int i = 0;
        for (String str : grid) {
            squares[i++] = str.chars().sorted().toArray();
        }

        for (int j = 0; j < columnLength; j++) {
            for (i = 0; i < squares.length - 1; i++) {
                if (squares[i][j] > squares[i + 1][j])  return "NO";
            }
        }

        return "YES";
    }

    @Test
    public void test1() {
        Assert.assertEquals("YES", gridChallenge(new String[] {"ebacd", "fghij", "olmkn", "trpqs", "xywuv"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals("NO", gridChallenge(new String[] {"opq", "sbc"}));
    }
}
