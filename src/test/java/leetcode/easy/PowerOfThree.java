package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

    // 재귀나 반복문 없이 풀어보는 걸 권장했는데 그런 방법이 떠오르지 않았음
    // 탐색을 하지 않으려면 미리 해를 구해놓으면 된다는 걸 알았는데도 수학적으로만 생각하다보니 간단한 걸 놓쳤음...반성해야겠다.
    private boolean isPowerOfThree(int n) {
        long temp = -1;
        int e = 0;
        while (temp < n) {
            temp = (long) Math.pow(3, e++);
        }
        return temp == n;
    }

    // 다른 사람의 풀이를 보니 수학적 공식 없이 재치있는 풀이가 몇 개 보였음
    // 첫번째 방법
//    private boolean isPowerOfThree(int n) {
//        // 1162261467 is 3^19,  3^20 is bigger than int
//        return ( 0 < n && 0 == 1162261467 % n);
//    }

    // 두번째 방법
//    int[] allPowerOfThree = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
//    private boolean isPowerOfThree(int n) {
//        return 0 <= Arrays.binarySearch(allPowerOfThree, n);
//    }

    // 세번째 방법
//    HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
//    private boolean isPowerOfThree(int n) {
//        return set.contains(n);
//    }

    @Test
    public void test9() {
        assertTrue(isPowerOfThree(9));
    }

    @Test
    public void test27() {
        assertTrue(isPowerOfThree(27));
    }

    @Test
    public void test0() {
        assertFalse(isPowerOfThree(0));
    }

    @Test
    public void test45() {
        assertFalse(isPowerOfThree(45));
    }

    @Test
    public void test2147483647() {
        assertFalse(isPowerOfThree(2147483647));
    }
}
