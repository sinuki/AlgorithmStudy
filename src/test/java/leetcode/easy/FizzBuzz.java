package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    private List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(num -> {
                    if (0 == num % 3 && 0 == num % 5) return "FizzBuzz";
                    if (0 == num % 3) return "Fizz";
                    if (0 == num % 5) return "Buzz";
                    return String.valueOf(num);
                })
                .collect(Collectors.toList());
    }

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        List<String> real = fizzBuzz(15);
        Assert.assertEquals(expected, real);
    }
}
