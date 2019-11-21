package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/add-binary/
 **/
public class AddBinary {

    private static final char ADJUST_NUM = '0';

    private String addBinary(String a, String b) {
       int aLength = a.length();
       int bLength = b.length();
       int i = 0;
       int carry = 0;
       StringBuilder sb = new StringBuilder();

       while (i < aLength || i < bLength || 0 < carry) {
           int aVal = i < aLength ? a.charAt(aLength - 1 - i) - ADJUST_NUM : 0;
           int bVal = i < bLength ? b.charAt(bLength - 1 - i) - ADJUST_NUM : 0;
           int sum = aVal + bVal + carry;
           sb.append(sum % 2);
           carry = sum / 2;
           i++;
       }

       return sb.reverse().toString();
    }

    @Test
    public void test1() {
        assertEquals("100", addBinary("11", "1"));
    }

    @Test
    public void test2() {
        assertEquals("10101", addBinary("1010", "1011"));
    }
}
