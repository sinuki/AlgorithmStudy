package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/plus-one/
 **/
public class PlusOne {

    private int[] plusOne(int[] digits) {
        return plus(digits, digits.length - 1);
    }

    private int[] plus(int[] digits, int index) {
        if (digits[index] == 9) {
            digits[index] = 0;

            if (index - 1 == -1) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;

                for (int i = 1; i < newArr.length; i++) {
                    newArr[i] = digits[i - 1];
                }

                return newArr;
            }

            return plus(digits, index - 1);
        } else {
            digits[index]++;
        }

        return digits;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {1, 1}, plusOne(new int[] {1, 0}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {1, 0}, plusOne(new int[] {9}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] {1, 0, 0}, plusOne(new int[] {9, 9}));
    }
}
