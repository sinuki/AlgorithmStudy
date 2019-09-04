package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/chocolate-feast/problem?isFullScreen=true
 */
public class ChocolateFeast {

    private int chocolateFeast(int n, int c, int m) {
        int chocolateCount = n / c;
        int returnedChocolateCount = chocolateCount / m;
        int restWrappersCount = chocolateCount % m;
        int sum = returnedChocolateCount + restWrappersCount;

        while (m <= sum) {
            restWrappersCount = sum % m;
            int newReturnedChocolateCount = sum / m;
            chocolateCount += newReturnedChocolateCount;
            sum = newReturnedChocolateCount + restWrappersCount;
        }

        return chocolateCount + returnedChocolateCount;
    }

    @Test
    public void test1() {
        assertEquals(6, chocolateFeast(10, 2, 5));
    }

    @Test
    public void test2() {
        assertEquals(3, chocolateFeast(12, 4, 4));
    }

    @Test
    public void test3() {
        assertEquals(5, chocolateFeast(6, 2, 2));
    }

    @Test
    public void test4() {
        assertEquals(3, chocolateFeast(2, 1, 2));
    }

    @Test
    public void test5() {
        assertEquals(1, chocolateFeast(1000000, 1000000, 1000000));
    }

    @Test
    public void test7() {
        assertEquals(899, chocolateFeast(43203, 60, 5));
    }
}
