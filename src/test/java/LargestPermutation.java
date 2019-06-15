import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/largest-permutation/problem?isFullScreen=true
 */
public class LargestPermutation {

    private int[] largestPermutation(int k, int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < k && !map.isEmpty(); i++) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            if (entry.getValue() == i) {
                k++;
                continue;
            }

            map.put(arr[i], entry.getValue());
            swap(arr, entry.getValue(), i);
        }
        return arr;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] {5, 2, 3, 4, 1}, largestPermutation(1, new int[] {4, 2, 3, 5, 1}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {3, 1, 2}, largestPermutation(1, new int[] {2, 1, 3}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] {2, 1}, largestPermutation(1, new int[] {2, 1}));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[] {4, 3, 2, 1}, largestPermutation(4, new int[] {1, 2, 3, 4}));
    }
}
