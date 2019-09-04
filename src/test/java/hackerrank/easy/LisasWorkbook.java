package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/lisa-workbook/problem?isFullScreen=true
 */
public class LisasWorkbook {

    private int workbook(int n, int k, int[] arr) {
        int specialProblemCount = 0;
        int pageNo = 1;

        for (int problemCount : arr) {
            for (int problemNo = 1; problemNo <= problemCount; problemNo++) {
                if (problemNo == pageNo)    specialProblemCount++;
                if (problemNo % k == 0) pageNo++;
            }
            if (problemCount % k != 0)  pageNo++;
        }

        return specialProblemCount;
    }

    @Test
    public void test1() {
        assertEquals(4, workbook(5, 3, new int[] {4, 2, 6, 1, 10}));
    }

    @Test
    public void test2() {
        assertEquals(8, workbook(10, 5, new int[] {3, 8, 15, 11, 14, 1, 9, 2, 24, 31}));
    }
}
