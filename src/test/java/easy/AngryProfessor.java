package easy;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true
 **/
public class AngryProfessor {

    private String angryProfessor(int k, int[] a) {
        int attendeeCount = (int) IntStream.of(a).filter(i -> i <= 0).count();
        return attendeeCount < k ? "YES" : "NO";
    }

    @Test
    public void test1() {
        assertEquals("YES", angryProfessor(3, new int[] {-1, -3, 4, 2}));
    }

    @Test
    public void test2() {
        assertEquals("NO", angryProfessor(2, new int[] {0, -1, 2, 1}));
    }
}
