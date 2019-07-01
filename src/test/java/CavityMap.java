import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/cavity-map/problem?isFullScreen=true
 */
public class CavityMap {

    private String[] cavityMap(String[] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length();
        char[][] map = convertCharArray(grid);

        for (int i = 1; i < rowLength - 1; i++) {
            for (int j = 1; j < columnLength - 1; j++) {
                char target = map[i][j];

                if (target > map[i + 1][j] && target > map[i - 1][j] && target > map[i][j + 1] && target > map[i][j - 1]) {
                    map[i][j] = 'X';
                }
            }
        }

        return convertString(map);
    }

    private char[][] convertCharArray(String[] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length();
        char[][] map = new char[rowLength][columnLength];
        int index = 0;

        for (String row : grid) {
            map[index++] = row.toCharArray();
        }

        return map;
    }

    private String[] convertString(char[][] map) {
        String[] result = new String[map.length];
        int i = 0;

        for (char[] chars : map) {
            result[i++] = new String(chars);
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new String[] {"1112", "1X12", "18X2", "1234"}, cavityMap(new String[] {"1112", "1912", "1892", "1234"}));
    }
}
