package leetcode.easy;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/valid-parentheses/
 **/
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (isOpened(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())    return false;
                char open = stack.pop();

                if (!isClosed(open, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpened(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isClosed(char prev, char curr) {
        return (prev == '(' && curr == ')') || (prev == '{' && curr == '}') || (prev == '[' && curr == ']');
    }

    @Test
    public void 정상테스트1() {
        assertTrue(isValid("()"));
    }

    @Test
    public void 정상테스트2() {
        assertTrue(isValid("{}"));
    }

    @Test
    public void 정상테스트3() {
        assertTrue(isValid("[]"));
    }

    @Test
    public void 비정상테스트1() {
        assertFalse(isValid("[]("));
    }

    @Test
    public void 비정상테스트2() {
        assertFalse(isValid("("));
    }

    @Test
    public void 비정상테스트3() {
        assertFalse(isValid(")"));
    }
}
