package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true
 */
public class CaesarCipher {

    private String caesarCipher(String s, int k) {
        if (k == 0) return s;
        k = k % 26;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int code = ((int) chars[i]) + k;

            if (isUpperCase(chars[i])) {
                chars[i] = (char) code;
                if (90 < code)  chars[i] = (char) (code - 26);
            } else if (isLowerCase(chars[i])) {
                chars[i] = (char) code;
                if (122 < code) chars[i] = (char) (code - 26);
            }
        }

        return new String(chars);
    }

    private boolean isUpperCase(char c) {
        int code = (int) c;
        return 65 <= code && 90 >= code;
    }

    private boolean isLowerCase(char c) {
        int code = (int) c;
        return 97 <= code && 122 >= code;
    }

    @Test
    public void test1() {
        assertEquals("defghijklmnopqrstuvwxyzabc", caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));
    }

    @Test
    public void test2() {
        assertEquals("Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb", caesarCipher("There's-a-starman-waiting-in-the-sky", 3));
    }

    @Test
    public void test3() {
        assertEquals("okffng-Qwvb", caesarCipher("middle-Outz", 2));
    }
}