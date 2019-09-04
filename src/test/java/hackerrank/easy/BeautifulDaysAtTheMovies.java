package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?isFullScreen=true
 **/
public class BeautifulDaysAtTheMovies {

    private int beautifulDays(int i, int j, int k) {
        int count = 0;

        for (;i <= j; i++) {
            if (Math.abs(i - reverseNumber(i)) % k == 0)    count++;
        }

        return count;
    }

    private int reverseNumber(int num) {
        int result = 0;

        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(2, beautifulDays(20, 23, 6));
    }
}
