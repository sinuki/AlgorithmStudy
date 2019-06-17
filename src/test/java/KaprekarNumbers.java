import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem?isFullScreen=true
 */
public class KaprekarNumbers {

    private String kaprekarNumbers(int p, int q) {
        List<Integer> result = new ArrayList<>();
        IntStream.rangeClosed(p, q).forEach(i -> {
            String temp = String.valueOf((long) Math.pow(i, 2));

            if (temp.length() < 2) {
                if (Long.parseLong(temp) == i) {
                    result.add(i);
                }
            } else {
                int substringIndex = temp.length() / 2;
                if (Long.parseLong(temp.substring(0, substringIndex)) + Long.parseLong(temp.substring(substringIndex)) == i) {
                    result.add(i);
                }
            }
        });
        String answer = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        return answer.isEmpty() ? "INVALID RANGE" : answer;
    }

    @Test
    public void test1() {
        assertEquals("1 9 45 55 99", kaprekarNumbers(1, 100));
    }

    @Test
    public void test2() {
        assertEquals("1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999", kaprekarNumbers(1, 99999));
    }

    @Test
    public void test3() {
        assertEquals("INVALID RANGE", kaprekarNumbers(400, 700));
    }

}
