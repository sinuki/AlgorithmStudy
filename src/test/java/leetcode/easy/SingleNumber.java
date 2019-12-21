package leetcode.easy;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * https://leetcode.com/problems/single-number/
 **/
public class SingleNumber {

    // 내가 생각한 방법
    // 시간복잡도 : n
    // 공간복잡도 : n
    private int singleNumber(int[] nums) {
        return IntStream.of(nums).boxed()
                        .collect(groupingBy(identity(), counting()))
                        .entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .findFirst().get().getKey();
    }
    // 다른 사람들 솔루션
    // 시간복잡도 : n
    // 공간복잡도 : 1
//    private int singleNumber(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            result ^= num;
//        }
//        return result;
//    }
}
