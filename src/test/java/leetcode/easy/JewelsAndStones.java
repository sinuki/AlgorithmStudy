package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    private int numJewelsInStones(String J, String S) {
        Set<Integer> jewelSet = J.chars().boxed().collect(Collectors.toSet());
        return (int) S.chars().filter(jewelSet::contains).count();
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, numJewelsInStones("z", "ZZ"));
    }
}
