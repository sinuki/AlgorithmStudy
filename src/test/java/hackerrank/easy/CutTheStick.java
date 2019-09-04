package hackerrank.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class CutTheStick {

    private int[] cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int min = IntStream.of(arr).min().orElse(0);

        while (1 <= min) {
            min = cut(result, arr, min);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int cut(List<Integer> result, int[] arr, int min) {
        result.add((int) IntStream.of(arr).filter(i -> 0 < i).count());

        for (int i = 0; i < arr.length; i++) {
            arr[i] -= min;
        }

        return IntStream.of(arr).filter(i -> 0 < i).min().orElse(0);
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {6, 4, 2, 1}, cutTheSticks(new int[] {5, 4, 4, 2, 2, 8}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {8, 6, 4, 1}, cutTheSticks(new int[] {1, 2, 3, 4, 3, 3, 2, 1}));
    }
}