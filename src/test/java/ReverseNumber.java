import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseNumber {

    private int reverseNumber(int number) {
        int reversedNumber = 0;

        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        }

        return reversedNumber;
    }

    @Test
    public void test() {
        assertEquals(21, reverseNumber(12));
    }

    @Test
    public void test1() {
        assertEquals(321, reverseNumber(123));
    }

    @Test
    public void test2() {
        assertEquals(4321, reverseNumber(1234));
    }
}