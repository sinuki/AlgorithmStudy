package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class RobotReturnToOrigin {

    // 다른 사람 풀이 - 시간복잡도는 동일하지만 더 적은 변수 + 가독성이 좋다 -
    private boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0, length = moves.length(); i < length; i++) {
            switch (moves.charAt(i)) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'L': x--; break;
                case 'R': x++; break;
            }
        }
        return 0 == x && 0 == y;
    }

    // 내가 푼 방법
//    private boolean judgeCircle(String moves) {
//        int up = 0;
//        int down = 0;
//        int left = 0;
//        int right = 0;
//        for (int i = 0, length = moves.length(); i < length; i++) {
//            switch (moves.charAt(i)) {
//                case 'U': up++; break;
//                case 'D': down++; break;
//                case 'L': left++; break;
//                case 'R': right++; break;
//            }
//        }
//        return 0 == (up - down) && 0 == (left - right);
//    }

    @Test
    public void test1() {
        assertTrue(judgeCircle("UD"));
    }

    @Test
    public void test2() {
        assertFalse(judgeCircle("LL"));
    }
}
