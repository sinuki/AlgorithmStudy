package hackerrank.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true
 **/
public class QueensAttack2 {

    static class Position {
        int rowIndex;
        int columnIndex;
        boolean isObstacle;

        Position(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    private int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        n -= 1;
        int queenRowIndex = r_q - 1;
        int queenColumnIndex = c_q - 1;
        Position top = new Position(n, queenColumnIndex);
        Position right = new Position(queenRowIndex, n);
        Position bottom = new Position(0, queenColumnIndex);
        Position left = new Position(queenRowIndex, 0);

        Position topRight = new Position(n, n);
        Position bottomRight = new Position(0, n);
        Position bottomLeft = new Position(0, 0);
        Position topLeft = new Position(n, 0);

        if (k > 0) {
            for (int[] obstacle : obstacles) {
                int obstacleRowIndex = obstacle[0] - 1;
                int obstacleColumnIndex = obstacle[1] - 1;

                // top
                if (queenColumnIndex == obstacleColumnIndex && queenRowIndex < obstacleRowIndex) {
                    top.rowIndex = Math.min(top.rowIndex, obstacleRowIndex);
                    top.isObstacle = true;
                }
                // right
                if (queenRowIndex == obstacleRowIndex && queenColumnIndex < obstacleColumnIndex) {
                    right.columnIndex = Math.min(right.columnIndex, obstacleColumnIndex);
                    right.isObstacle = true;
                }
                // bottom
                if (queenColumnIndex == obstacleColumnIndex && queenRowIndex > obstacleRowIndex) {
                    bottom.rowIndex = Math.max(bottom.rowIndex, obstacleRowIndex);
                    bottom.isObstacle = true;
                }
                // left
                if (queenRowIndex == obstacleRowIndex && queenColumnIndex > obstacleColumnIndex) {
                    left.columnIndex = Math.max(left.columnIndex, obstacleColumnIndex);
                    left.isObstacle = true;
                }
                // topRight
                if (obstacleRowIndex - queenRowIndex == obstacleColumnIndex - queenColumnIndex && queenRowIndex < obstacleRowIndex && queenColumnIndex < obstacleColumnIndex) {
                    topRight.rowIndex = Math.min(topRight.rowIndex, obstacleRowIndex);
                    topRight.columnIndex = Math.min(topRight.columnIndex, obstacleColumnIndex);
                    topRight.isObstacle = true;
                }
                // bottomRight
                if (queenRowIndex - obstacleRowIndex == obstacleColumnIndex - queenColumnIndex && queenRowIndex > obstacleRowIndex && queenColumnIndex < obstacleColumnIndex) {
                    bottomRight.rowIndex = Math.max(bottomRight.rowIndex, obstacleRowIndex);
                    bottomRight.columnIndex = Math.min(bottomRight.columnIndex, obstacleColumnIndex);
                    bottomRight.isObstacle = true;
                }
                // bottomLeft
                if (queenRowIndex - obstacleRowIndex == queenColumnIndex - obstacleColumnIndex && queenRowIndex > obstacleRowIndex && queenColumnIndex > obstacleColumnIndex) {
                    bottomLeft.rowIndex = Math.max(bottomLeft.rowIndex, obstacleRowIndex);
                    bottomLeft.columnIndex = Math.max(bottomLeft.columnIndex, obstacleColumnIndex);
                    bottomLeft.isObstacle = true;
                }
                // topLeft
                if (obstacleRowIndex - queenRowIndex == queenColumnIndex - obstacleColumnIndex && queenRowIndex < obstacleRowIndex && queenColumnIndex > obstacleColumnIndex) {
                    topLeft.rowIndex = Math.min(topLeft.rowIndex, obstacleRowIndex);
                    topLeft.columnIndex = Math.max(topLeft.columnIndex, obstacleColumnIndex);
                    topLeft.isObstacle = true;
                }
            }
        }

        int count = 0;

        count += top.rowIndex - queenRowIndex;
        if (top.isObstacle)    count--;

        count += Math.min(topRight.rowIndex - queenRowIndex, topRight.columnIndex - queenColumnIndex);
        if (topRight.isObstacle)    count--;

        count += right.columnIndex - queenColumnIndex;
        if (right.isObstacle)    count--;

        count += Math.min(queenRowIndex - bottomRight.rowIndex, bottomRight.columnIndex - queenColumnIndex);
        if (bottomRight.isObstacle)    count--;

        count += queenRowIndex - bottom.rowIndex;
        if (bottom.isObstacle)    count--;

        count += Math.min(queenRowIndex - bottomLeft.rowIndex, queenColumnIndex - bottomLeft.columnIndex);
        if (bottomLeft.isObstacle)    count--;

        count += queenColumnIndex - left.columnIndex;
        if (left.isObstacle)    count--;

        count += Math.min(topLeft.rowIndex - queenRowIndex, queenColumnIndex - topLeft.columnIndex);
        if (topLeft.isObstacle)    count--;

        return count;
    }

    @Test
    public void test1() {
        assertEquals(9, queensAttack(4, 0, 4, 4, null));
    }

    @Test
    public void test2() {
        assertEquals(10, queensAttack(5, 3, 4, 3, new int[][] {{5, 5}, {4, 2}, {2, 3}}));
    }
}
