package leetcode.easy;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInStream {

    static class KthLargest {
        private int k;
        private PriorityQueue<Integer> queue;

        KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            IntStream.of(nums).forEach(queue::offer);
        }

        int add(int val) {
            queue.offer(val);
            int diff = queue.size() - k;
            for (int i = 0; i < diff; i++) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    @Test
    public void test1() {
        KthLargest instance = new KthLargest(3, new int[] {4, 5, 8, 2});
        int[][] expecteds = new int[][] {{3, 4}, {5, 5}, {10, 5}, {9, 8}, {4, 8}};
        for (int[] expected : expecteds) {
            assertEquals(expected[1], instance.add(expected[0]));
        }
    }
}
