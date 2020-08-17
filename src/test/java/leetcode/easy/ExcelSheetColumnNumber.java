package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    private int titleToNumber(String s) {
        int number = 0;
        int over = 26;
        for (int i = 0; i < s.length(); i++) {
            number = number * over + (s.charAt(i) - 'A' + 1);
        }
        return number;
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(27, titleToNumber("AA"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(28, titleToNumber("AB"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(701, titleToNumber("ZY"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(703, titleToNumber("AAA"));
    }
}
