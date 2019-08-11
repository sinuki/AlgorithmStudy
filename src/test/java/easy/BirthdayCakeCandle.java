package easy;

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
                            int order = 0;
                            int key1 = entry1.getKey();
                            int key2 = entry2.getKey();
                            long value1 = entry1.getValue();
                            long value2 = entry2.getValue();

                            if (value1 < value2) {
                                order = 1;
                            } else if (value1 > value2) {
                                order = -1;
                            } else {
                                if (key1 < key2) {
                                    order = 1;
                                } else if (key1 > key2) {
                                    order = -1;
                                }
                            }

                            return order;
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
