package leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/pascals-triangle/
 **/
public class PascalsTriangle {

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prevList = rows.get(i - 1);
                    int prev1 = prevList.get(j - 1);
                    int prev2 = prevList.get(j);
                    row.add(prev1 + prev2);
                }
            }
            rows.add(row);
        }
        return rows;
    }

    @Test
    public void test1() {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Arrays.asList(1));
        rows.add(Arrays.asList(1, 1));
        rows.add(Arrays.asList(1, 2, 1));
        rows.add(Arrays.asList(1, 3, 3, 1));
        rows.add(Arrays.asList(1, 4, 6, 4, 1));
        assertEquals(rows, generate(5));
    }
}
