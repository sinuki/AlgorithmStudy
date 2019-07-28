package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/string-construction/problem?isFullScreen=true
 */
public class StringConstruction {

    private int stringConstruction(String s) {
        return (int) s.chars().distinct().count();
    }

    @Test
    public void test1() {
        assertEquals(4, stringConstruction("abcd"));
    }

    @Test
    public void test2() {
        assertEquals(2, stringConstruction("abab"));
    }

    @Test
    public void test3() {
        assertEquals(4, stringConstruction("abadbc"));
    }

}