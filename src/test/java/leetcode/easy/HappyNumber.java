package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    private HashSet<Integer> checker = new HashSet<>();

    private boolean isHappy(int n) {
        if (1 == n) return true;
        if (!checker.add(n)) return false;

        String[] nums = String.valueOf(n).split("");
        int sum = 0;
        for (String num : nums) {
            sum += Math.pow(Integer.parseInt(num), 2);
        }
        return isHappy(sum);
    }

    @Test
    public void happy() {
        Assert.assertTrue(isHappy(19));
    }

    @Test
    public void unhappy() {
        Assert.assertFalse(isHappy(20));
    }
}
