package easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SherlokAndArray {

    private String balancedSums(List<Integer> arr) {
        int leftSum = 0;
        int rightSum = arr.stream().skip(1).mapToInt(i -> i).sum();

        for (int i = 0, j = arr.size() - 1; i < j;) {
            if (leftSum < rightSum) {
                leftSum += arr.get(i++);
                rightSum -= arr.get(i);
            } else {
                return leftSum == rightSum ? "YES" : "NO";
            }
        }

        return leftSum == rightSum ? "YES" : "NO";
    }

    @Test
    public void test1() {
        Assert.assertEquals("NO", balancedSums(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void test2() {
        Assert.assertEquals("YES", balancedSums(Arrays.asList(1, 2, 3, 3)));
    }

    @Test
    public void test3() {
        Assert.assertEquals("YES", balancedSums(Arrays.asList(1)));
    }

    @Test
    public void test4() {
        Assert.assertEquals("YES", balancedSums(Arrays.asList(1, 1, 4, 1, 1)));
    }

    @Test
    public void test5() {
        Assert.assertEquals("YES", balancedSums(Arrays.asList(2, 0, 0, 0)));
    }

    @Test
    public void test6() {
        Assert.assertEquals("YES", balancedSums(Arrays.asList(0, 0, 2, 0)));
    }
}
