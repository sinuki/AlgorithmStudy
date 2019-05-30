import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class WeightedUniformStrings {

    private String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];

        IntStream.range(0, queries.length).forEach(index -> {
            boolean isOK = false;
            int query = queries[index];
            int prev = s.charAt(0) - 96;
            int i = 1;
            int sequencial = 1;

            while (i < s.length()) {
                int curr = s.charAt(i) - 96;
                if (prev == curr) {
                    sequencial++;
                } else {
                    isOK = query % prev == 0 && query / prev <= sequencial;
                    if (isOK)   break;

                    prev = curr;
                    sequencial = 1;
                }

                isOK = query % prev == 0 && query / prev <= sequencial;
                if (isOK)   break;
                i++;
            }

            result[index] = isOK ? "Yes" : "No";
        });

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new String[] {"Yes" , "Yes" , "Yes" , "Yes" , "No" , "No"}, weightedUniformStrings("abccddde", new int[] {1 , 3 , 12 , 5 , 9 , 10}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new String[] {"Yes" , "No" , "Yes" , "Yes" , "No"}, weightedUniformStrings("aaabbbbcccddd", new int[] {9 , 7 , 8 , 12 , 5}));
    }

}