package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {

    // 두 번째 풀었던 방법. 예외 처리가 없어졌고 코드도 단순화되었다.
    public String licenseKeyFormatting(String S, int K) {
        char dash = '-';
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1, checker = 0; 0 <= i; i--) {
            char c = S.charAt(i);
            if (c == dash) continue;
            if (checker == K) {
                sb.append(dash);
                checker = 0;
            }
            sb.append(Character.toUpperCase(c));
            checker++;
        }
        return sb.reverse().toString();
    }

    // 처음에 풀었던 방법. 많은 예외 처리가 필요하고 코드가 복잡하다.
//    public String licenseKeyFormatting(String S, int K) {
//        String replacedStr = S.replace("-", "");
//        int length = replacedStr.length();
//        if (replacedStr.isEmpty()) return "";
//        if (0 == length % K) {
//            return reformat(replacedStr, 0, K);
//        }
//        String str = replacedStr.substring(0, length % K);
//        if (length < K) return str;
//        return str.toUpperCase() + "-" + reformat(replacedStr, str.length(), K);
//    }

//    private String reformat(String sumStr, int initVal, int K) {
//        StringBuilder sb = new StringBuilder();
//        int sumStrLength = sumStr.length();
//        int init = initVal;
//        while (init < sumStrLength) {
//            if (initVal < init) {
//                sb.append("-");
//            }
//            sb.append(sumStr.substring(init, init + K));
//            init += K;
//        }
//        return sb.toString().toUpperCase();
//    }

    @Test
    public void test1() {
        assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    public void test2() {
        assertEquals("2-5G-3J", licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    public void test3() {
        assertEquals("24A0-R74K", licenseKeyFormatting("2-4A0r7-4k", 4));
    }

    @Test
    public void test4() {
        assertEquals("24-A0R-74K", licenseKeyFormatting("2-4A0r7-4k", 3));
    }

    @Test
    public void test5() {
        assertEquals("2", licenseKeyFormatting("2", 2));
    }

    @Test
    public void test6() {
        assertEquals("", licenseKeyFormatting("---", 3));
    }
}
