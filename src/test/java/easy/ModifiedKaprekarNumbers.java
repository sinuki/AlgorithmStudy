package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem?isFullScreen=true
 **/
public class ModifiedKaprekarNumbers {

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

}
