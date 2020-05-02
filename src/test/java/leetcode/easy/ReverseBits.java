package leetcode.easy;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {

    private int reverseBits(int n) {
        String partialBinary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 32 - partialBinary.length()).forEach(i -> sb.append("0"));
        String binary = sb.append(partialBinary).toString();
        return IntStream.range(0, 32).reduce(0, (acc, index) -> '0' == binary.charAt(index) ? acc : acc + (1 << index));
    }

    @Test
    public void test1() {
        assertEquals(0, reverseBits(0));
    }

    @Test
    public void test2() {
        assertEquals(964_176_192 , reverseBits(43_261_596));
    }

    @Test
    public void test3() {
        assertEquals(-1_073_741_825 , reverseBits(-3));
    }
}
