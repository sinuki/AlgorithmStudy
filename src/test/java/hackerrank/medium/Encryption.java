package hackerrank.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true
 **/
public class Encryption {

    private String encryption(String s) {
        char[][] encoded = encode(s.replace(" ", ""));
        return encrypt(encoded);
    }

    private char[][] encode(String s) {
        int length = s.length();
        double sqrt = Math.sqrt(length);
        int rows = (int) sqrt;
        int columns = (int) Math.ceil(sqrt);

        if (rows * columns < length) {
            rows += 1;
        }

        char[][] encoded = new char[rows][columns];
        for (int i = 0, index = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++, index++) {
                if (index >= length)    break;
                encoded[i][j] = s.charAt(index);
            }
        }

        return encoded;
    }

    private String encrypt(char[][] result) {
        int rows = result.length;
        int columns = result[0].length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns; i++) {
            if (i > 0)  sb.append(" ");

            for (int j = 0; j < rows; j++) {
                if (result[j][i] != '\0') {
                    sb.append(result[j][i]);
                }
            }
        }

        return sb.toString();
    }


    @Test
    public void test1() {
        assertEquals("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau", encryption("if man was meant to stay on the ground god would have given us roots"));
    }

    @Test
    public void test2() {
        assertEquals("hae and via ecy", encryption("haveaniceday"));
    }

    @Test
    public void test3() {
        assertEquals("clu hlt io", encryption("chillout"));
    }

}
