package hackerrank.easy;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
 **/
public class BirthdayCakeCandle {

    private int birthdayCakeCandles(int[] ar) {
        return IntStream.of(ar)
                        .boxed()
                        .collect(groupingBy(Function.identity(), counting()))
                        .entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> {
                            int keyOrder = entry1.getKey().compareTo(entry2.getKey()) * - 1;
                            int valueOrder = entry1.getValue().compareTo(entry2.getValue()) * - 1;

                            if (valueOrder == 0)    return keyOrder;
                            return valueOrder;
                        })
                        .findFirst()
                        .get()
                        .getValue()
                        .intValue();
    }

    @Test
    public void test1() {
        assertEquals(2, birthdayCakeCandles(new int[] {3, 2, 1, 3}));
    }
}
