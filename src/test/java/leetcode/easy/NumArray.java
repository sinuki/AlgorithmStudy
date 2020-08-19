package leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {

    static class NumArrayTest {
        private final int[] nums;

        // 첫번째, 두번째 방법용
//        NumArrayTest(int[] nums) {
//            this.nums = nums;
//        }

        // 첫번째 방법. 코드는 간결하지만 이렇게 풀면 타임아웃 남.
//    public int sumRange(int i, int j) {
//        return IntStream.of(nums).skip(i).limit(j - i + 1).sum();
//    }

        /**
         * 두번째 방법. 통과하긴 하지만 아래 두 조건을 생각하면 좋은 방법이 아님.
         *
         * You may assume that the array does not change.
         * There are many calls to sumRange function.
         */
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        while (i <= j) {
//            sum += nums[i++];
//        }
//        return sum;
//    }

        // best solution
        NumArrayTest(int[] nums) {
            this.nums = new int[nums.length + 1];
            // 미리 합을 구해놓는다.
            for (int i = 0; i < nums.length; i++) {
                this.nums[i + 1] = this.nums[i] + nums[i];
            }
        }

        // best solution
        public int sumRange(int i, int j) {
            return this.nums[j + 1] - this.nums[i];
        }
    }

    NumArrayTest obj;

    @Before
    public void setup() {
        obj = new NumArrayTest(new int[] {-2, 0, 3, -5, 2, -1});
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, obj.sumRange(0, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, obj.sumRange(2, 5));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-3, obj.sumRange(0, 5));
    }
}
