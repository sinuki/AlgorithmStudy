package hackerrank.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MarcsCakeWalk {

    private long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long result = 0;
        int exp = 0;

        for (int i = calorie.length - 1; 0 <= i; i--) {
            result += Math.pow(2, exp++) * calorie[i];
        }

        return result;
    }

    @Test
    public void test() {
        assertEquals(11, marcsCakewalk(new int[] {1, 3, 2}));
    }
}
