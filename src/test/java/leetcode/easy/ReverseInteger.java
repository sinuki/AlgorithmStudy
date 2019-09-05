package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-integer/
 **/
public class ReverseInteger {

    private int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            reversed = x % 10 + reversed * 10;
            x /= 10;
        }

        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        return (int) ((max < reversed || min > reversed) ? 0 : reversed);
    }

    @Test
    public void 양수_테스트() {
        assertEquals(321, reverse(123));
    }

    @Test
    public void 음수_테스트() {
        assertEquals(-321, reverse(-123));
    }

    @Test
    public void 인트초과_테스트() {
        assertEquals(0, reverse(1234567899));
    }
}
