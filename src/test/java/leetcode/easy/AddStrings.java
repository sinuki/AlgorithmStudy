package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

    private String addStrings(String num1, String num2) {
        char[] numbers1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] numbers2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int size = Math.max(numbers1.length, numbers2.length);
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size || 0 < carry; i++) {
            int value1 = i < numbers1.length ? numbers1[i] - '0' : 0;
            int value2 = i < numbers2.length ? numbers2[i] - '0' : 0;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
        }
        return result.reverse().toString();
    }

    @Test
    public void test1() {
        assertEquals("5555", addStrings("1234", "4321"));
    }

    @Test
    public void test2() {
        assertEquals("11011", addStrings("9009", "2002"));
    }
}
