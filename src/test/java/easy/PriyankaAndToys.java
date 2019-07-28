package easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PriyankaAndToys {

    private int toys(int[] w) {
        Arrays.sort(w);
        int count = 1;
        int min = w[0];
        int i = 0;

        do {
            if (min + 4 < w[i]) {
                count++;
                min = w[i];
            }
        } while (++i < w.length);

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, toys(new int[] {12, 15, 7, 8, 19, 24}));
    }
}
