package leetcode.easy;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

    // 더 심플한 방법
    private int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> checker = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (checker.contains(c)) {
                checker.remove(c);
                count += 2;
            } else {
                checker.add(c);
            }
        }
        // 모든 문자가 짝수 번 등장했으면 셋은 비어져있을 거고, 홀수 번 등장한 문자가 있으면 셋에 잔여 데이터가 존재할 것이므로 +1을 해준다.
        return checker.isEmpty() ? count : count + 1;
    }

    // 처음에 푼 방법
//    private int longestPalindrome(String s) {
//        // 회문이 되려면 모든 문자가 짝수개이거나 1개 문자를 제외하고 모든 문자가 짝수개여야 함.
//        HashMap<Character, Integer> mapper = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            mapper.merge(c, 1, Integer::sum);
//        }
//        boolean isFirst = true;
//        int count = 0;
//        for (int value : mapper.values()) {
//            boolean isEven = 0 == value % 2;
//            // 짝수는 조건 없이 전부 추가
//            if (isEven) {
//                count += value;
//            } else {
//                // 첫번째 홀수 문자인 경우
//                if (isFirst) {
//                    count += value;
//                    isFirst = false;
//                    // 3개 이상의 홀수 문자인 경우
//                } else if (0 < value - 1) {
//                    count += (value - 1);
//                }
//            }
//        }
//        return count;
//    }

    @Test
    public void test1() {
        assertEquals(7, longestPalindrome("abccccdd"));
    }

    @Test
    public void test2() {
        assertEquals(9, longestPalindrome("bbbccccdd"));
    }

    @Test
    public void test3() {
        assertEquals(11, longestPalindrome("bbbccccddaaa"));
    }

    @Test
    public void test4() {
        assertEquals(9, longestPalindrome("bbbccccdda"));
    }

    @Test
    public void test5() {
        assertEquals(3, longestPalindrome("ccc"));
    }

    @Test
    public void test6() {
        assertEquals(9, longestPalindrome("ababababa"));
    }
}
