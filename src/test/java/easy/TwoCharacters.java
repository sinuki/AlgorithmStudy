package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/two-characters/problem?isFullScreen=true
 **/
public class TwoCharacters {

    private int alternate(String s) {
        int max = 0;
        String temp = s.chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        for (int i = 0; i < temp.length() - 1; i++) {
            for (int j = i + 1; j < temp.length(); j++) {
                StringBuilder sb = new StringBuilder();
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    if (c == temp.charAt(i) || c == temp.charAt(j)) {
                        sb.appendCodePoint(c);
                    }
                }
                String result = sb.toString();
                boolean isAlternating = isAlternated(result);

                if (isAlternating && max < result.length()) {
                    max = result.length();
                }
            }
        }

        return max;
    }

    private boolean isAlternated(String str) {
        boolean isAlternating = false;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                isAlternating = false;
                break;
            } else {
                isAlternating = true;
            }
        }

        return isAlternating;
    }

    @Test
    public void test1() {
        assertEquals(5, alternate("beabeefeab"));
    }
}
