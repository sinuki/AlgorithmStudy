package hackerrank.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Anagram {
    private int anagram(String s) {
        if (s.length() % 2 != 0)    return -1;

        int middle = s.length() / 2;
        String first = s.substring(0, middle);
        StringBuilder second = new StringBuilder(s.substring(middle));
        int changeCount = 0;

        for (int i = 0; i < first.length(); i++) {
            int index = second.indexOf(String.valueOf(first.charAt(i)));

            if (index == -1) {
                changeCount++;
                continue;
            }

            second = second.deleteCharAt(index);
        }

        return changeCount;
    }

    @Test
    public void test1() { assertEquals(10, anagram("hhpddlnnsjfoyxpciioigvjqzfbpllssuj"));}
    @Test
    public void test2() { assertEquals(13, anagram("xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj"));}
    @Test
    public void test3() { assertEquals(5, anagram("dnqaurlplofnrtmh"));}
    @Test
    public void test4() { assertEquals(26, anagram("aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb"));}
    @Test
    public void test5() { assertEquals(15, anagram("lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad"));}
    @Test
    public void test6() { assertEquals(-1, anagram("drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe"));}
    @Test
    public void test7() { assertEquals(3, anagram("ubulzt"));}
    @Test
    public void test8() { assertEquals(13, anagram("vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy"));}
    @Test
    public void test9() { assertEquals(13, anagram("xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa"));}
    @Test
    public void test10() { assertEquals(-1, anagram("gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv"));}
}
