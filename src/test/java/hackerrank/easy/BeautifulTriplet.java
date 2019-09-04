package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 */
public class BeautifulTriplet {

    private int beautifulTriplets(int d, int[] arr) {
        if (3 > arr.length) return 0;
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int start = arr[i];
            int triplet = 1;
            for (int j = i + 1; j < arr.length && triplet < 3; j++) {
                if (start + d == arr[j]) {
                    start = arr[j];
                    triplet++;
                }
            }

            if (triplet == 3)   count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, beautifulTriplets(3, new int[] {1, 2, 4, 5, 7, 8, 10}));
    }

    @Test
    public void test2() {
        assertEquals(2, beautifulTriplets(3, new int[] {1, 6, 7, 7, 8 ,10, 12, 13, 14, 19}));
    }
}
