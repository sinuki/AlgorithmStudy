package easy;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem?isFullScreen=true
 */
public class EqualizeTheArray {

    private int equalizeArray(int[] arr) {
        long max = IntStream.of(arr)
                            .boxed()
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet().stream()
                            .max(Comparator.comparing(Map.Entry::getValue))
                            .get().getValue();
        return arr.length - (int) max;
    }

    @Test
    public void test1() {
        assertEquals(2, equalizeArray(new int[] {3, 3, 2, 1, 3}));
    }

}