package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    // 좀 더 심플한 방법
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sIndex == s.length()) break;
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex == s.length();
    }

    // 처음 푼 방법
//    public boolean isSubsequence(String s, String t) {
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        s.chars().forEach(queue::offer);
//        for (int i = 0; i < t.length(); i++) {
//            if (queue.isEmpty()) return true;
//            if (queue.peek() == (int) t.charAt(i)) {
//                queue.removeFirst();
//            }
//        }
//        return queue.isEmpty();
//    }

    @Test
    public void test1() {
        Assert.assertTrue(isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isSubsequence("axc", "ahbgdc"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isSubsequence("acb", "ahbgdc"));
    }
}
