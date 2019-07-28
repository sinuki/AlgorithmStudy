package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/strange-code/problem?isFullScreen=true
 */
public class StrangeCounter {

    private long strangeCounter(long t) {
        long init = 3L;
        while (t > init) {
            t -= init;
            init *= 2;
        }
        return init - t + 1;
    }

    @Test
    public void test1() {
        assertEquals(6L, strangeCounter(4L));
    }

    @Test
    public void test2() {
        assertEquals(5L, strangeCounter(17L));
    }
}
