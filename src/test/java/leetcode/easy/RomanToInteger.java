package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/roman-to-integer/
 **/
public class RomanToInteger {

    public int romanToInt(String s) {
        int length = s.length();
        int time = 0;

        for (int i = 0; i < length;) {
            String word = s.substring(i, Math.min(i + 2, length));
            int temp = convertTimeByTwoLetters(word);

            if (temp == 0) {
                temp = convertTimeByOneLetter(word.substring(0, 1));
                i++;
            } else {
                i += 2;
            }

            time += temp;
        }

        return time;
    }

    private int convertTimeByTwoLetters(String word) {
        switch (word) {
            case "IV":  return 4;
            case "IX":  return 9;
            case "XL":  return 40;
            case "XC":  return 90;
            case "CD":  return 400;
            case "CM":  return 900;
            default:    return 0;
        }
    }

    private int convertTimeByOneLetter(String word) {
        switch (word) {
            case "I":   return 1;
            case "V":   return 5;
            case "X":   return 10;
            case "L":   return 50;
            case "C":   return 100;
            case "D":   return 500;
            case "M":   return 1000;
            default:    return 0;
        }
    }

    @Test
    public void test1() {
        assertEquals(3, romanToInt("III"));
    }

    @Test
    public void test2() {
        assertEquals(4, romanToInt("IV"));
    }

    @Test
    public void test3() {
        assertEquals(9, romanToInt("IX"));
    }

    @Test
    public void test4() {
        assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    public void test5() {
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
