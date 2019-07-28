package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheLoveLetterMystery {

    private int theLoveLetterMystery(String s) {
        int changeCount = 0;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            changeCount += Math.abs(s.charAt(i) - s.charAt(j));
        }

        return changeCount;
    }

    @Test
    public void test1() {
        assertEquals(2, theLoveLetterMystery("abc"));
    }

    @Test
    public void test2() {
        assertEquals(0, theLoveLetterMystery("abcba"));
    }

    @Test
    public void test3() {
        assertEquals(4, theLoveLetterMystery("abcd"));
    }


    @Test
    public void test4() {
        assertEquals(2, theLoveLetterMystery("cba"));
    }

}