package medium;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true
 **/
public class SherlockAndTheValidString {

    private String isValid(String s) {
        final String YES = "YES";
        Map<Integer, Long> map = s.chars().boxed().collect(groupingBy(Function.identity(), counting()));
        Map<Integer, Long> stat = map.entrySet().stream().map(e -> e.getValue().intValue()).collect(groupingBy(Function.identity(), counting()));

        if (stat.size() == 1)    return YES;
        if (stat.size() == 2) {
            Map.Entry<Integer, Long> max = stat.entrySet().stream().max(Map.Entry.comparingByKey()).get();
            Map.Entry<Integer, Long> min = stat.entrySet().stream().min(Map.Entry.comparingByKey()).get();

            if ((min.getKey() == 1 && min.getValue() == 1) || (max.getKey() - min.getKey() == 1 && max.getValue() == 1))    return YES;
        }

        return "NO";
    }

    @Test
    public void test1() {
        assertEquals("NO", isValid("aaaabbcc"));
    }

    @Test
    public void test2() {
        assertEquals("YES", isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
    }

    @Test
    public void test3() {
        assertEquals("NO", isValid("aaaaabc"));
    }
}
