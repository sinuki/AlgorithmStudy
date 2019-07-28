package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeIndex {

    private int palindromeIndex(String s) {
        int removedIndex = -1;
        int middle = s.length() / 2;

        for (int i = 0, j = s.length() - 1; i < middle; i++, j--) {
            if (s.charAt(i) == s.charAt(j)) continue;
            if (isPalindrome(new StringBuilder(s).deleteCharAt(i).toString()))  return i;
            if (isPalindrome(new StringBuilder(s).deleteCharAt(j).toString()))  return j;
            break;
        }

        return removedIndex;
    }

    private boolean isPalindrome(String s) {
        boolean isPalindrome = false;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            isPalindrome = s.charAt(i) == s.charAt(j);
            if (!isPalindrome)  break;
        }

        return isPalindrome;
    }

    @Test
    public void test1() {
        assertEquals(3, palindromeIndex("aaab"));
    }

    @Test
    public void test2() {
        assertEquals(0, palindromeIndex("baa"));
    }

    @Test
    public void test3() {
        assertEquals(-1, palindromeIndex("aaa"));
    }

    @Test
    public void test4() {
        assertEquals(1, palindromeIndex("abca"));
    }

    @Test
    public void test5() {
        assertEquals(1, palindromeIndex("quyjjdcgsvvsgcdjjyq"));
    }

    @Test
    public void test6() {
        assertEquals(8, palindromeIndex("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh"));
    }

    @Test
    public void test7() {
        assertEquals(33, palindromeIndex("fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf"));
    }

    @Test
    public void test8() {
        assertEquals(23, palindromeIndex("bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb"));
    }

    @Test
    public void test9() {
        assertEquals(25, palindromeIndex("fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf"));
    }

    @Test
    public void test10() {
        assertEquals(44, palindromeIndex("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm"));
    }

    @Test
    public void test11() {
        assertEquals(20, palindromeIndex("tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt"));
    }

    @Test
    public void test12() {
        assertEquals(-1, palindromeIndex("lhrxvssvxrhl"));
    }

    @Test
    public void test13() {
        assertEquals(14, palindromeIndex("prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp"));
    }

    @Test
    public void test14() {
        assertEquals(-1, palindromeIndex("kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk"));
    }
}