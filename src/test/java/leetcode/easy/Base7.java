package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/base-7/
 */
public class Base7 {

    // best solution
    private String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    // 내가 푼 방법
//    private String convertToBase7(int num) {
//        if (0 == num) return "0";
//        boolean isNegative = 0 > num;
//        num = 0 > num ? num * -1 : num;
//        StringBuilder sb = new StringBuilder();
//        while (0 != num) {
//            sb.append(num % 7);
//            num /= 7;
//        }
//        return sb.append(isNegative ? "-" : "").reverse().toString();
//    }

    @Test
    public void test1() {
        assertEquals("202", convertToBase7(100));
    }

    @Test
    public void test2() {
        assertEquals("-10", convertToBase7(-7));
    }

    @Test
    public void test3() {
        assertEquals("0", convertToBase7(0));
    }
}
