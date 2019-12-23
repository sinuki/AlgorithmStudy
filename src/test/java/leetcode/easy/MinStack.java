package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/min-stack/
 **/
public class MinStack {

    private Deque<Integer> elements;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        elements = new ArrayDeque<>();
    }

    public void push(int x) {
        elements.push(x);
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        if (elements.isEmpty()) return;
        if (min == elements.pop()) {
            min = elements.stream().mapToInt(i -> (int) i).min().orElse(Integer.MAX_VALUE);
        }
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return min;
    }
}
