import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem?h_r=internal-search&isFullScreen=true
 */
public class MigratoryBirds {

    private int migratoryBirds(List<Integer> arr) {
        return arr.stream()
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                  .entrySet().stream()
                  .sorted(Map.Entry.comparingByKey())
                  .max(Map.Entry.comparingByValue())
                  .get().getKey();
    }

    @Test
    public void test1() {
        assertEquals(4, migratoryBirds(Arrays.asList(1,4,4,4,5,3)));
    }

    @Test
    public void test2() {
        assertEquals(3, migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }
}