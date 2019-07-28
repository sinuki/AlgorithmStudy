package medium;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
 **/
public class ExtraLongFactorials {

    private String extraLongFactorials(int n) {
        BigInteger boundary = BigInteger.valueOf(2);
        BigInteger init = BigInteger.valueOf(n);
        BigInteger result = init;

        while (boundary.compareTo(init) < 1) {
            init = init.subtract(BigInteger.ONE);
            result = result.multiply(init);
        }

        return result.toString();
    }

    @Test
    public void test1() {
        assertEquals("15511210043330985984000000", extraLongFactorials(25));
    }

    @Test
    public void test2() {
        assertEquals("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000", extraLongFactorials(100));
    }
}
