package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

    /**
     * t는 s를 기반으로 랜덤하게 셔플링되고 한 글자가 더 붙는다는 조건이 존재.
     * 그럼 t는 무조건 s보다 기니까 기본값을 t의 가장 마지막값으로 설정하고
     * s(원본)은 빼고, 파생(t)은 더해주면 최종적으로 차분 만큼의 값을 획득할 수 있음.
     */
    private char findTheDifference(String s, String t) {
        int c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c -= s.charAt(i);
            c += t.charAt(i);
        }
        return (char) c;
    }

    @Test
    public void test1() {
        assertEquals('e', findTheDifference("abcd", "abcde"));
    }

    @Test
    public void test2() {
        assertEquals('e', findTheDifference("abcd", "aecbd"));
    }
}
