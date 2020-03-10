package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    int firstBadVersion;
    boolean isBadVersion(int version) {
        return firstBadVersion <= version;
    }

    private int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            // 처음에는 이 부분을 (low + high) / 2로 했는데 입력값으로 Integer.MAX_VALUE 가 들어오면 오버 플로우가 일어나서 무한 루프 발생
            // 그래서 무한루프를 안 태우면서 중앙값을 취득하기 위해 아래처럼 수정하니 통과
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    @Test
    public void test1() {
        firstBadVersion = 4;
        assertEquals(4, firstBadVersion(5));
    }

    @Test
    public void test2() {
        firstBadVersion = 1702766719;
        assertEquals(1702766719, firstBadVersion(2126753390));
    }
}
