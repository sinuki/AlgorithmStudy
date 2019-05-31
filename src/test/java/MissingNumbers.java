import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MissingNumbers {

    private int[] missingNumbers(int[] arr, int[] brr) {
        Arrays.sort(arr);
        Arrays.sort(brr);
        List<Integer> result = new ArrayList<>();

        for (int i = 0, j = 0; i < brr.length; i++) {
            if (j < arr.length && brr[i] == arr[j]) {
                j++;
                continue;
            }

            result.add(brr[i]);
        }

        return result.stream().mapToInt(i -> i).distinct().toArray();
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {204, 205, 206}, missingNumbers(new int[] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206}, new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204}));
    }
}
