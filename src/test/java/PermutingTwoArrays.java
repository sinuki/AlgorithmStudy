import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem?isFullScreen=true
 */
public class PermutingTwoArrays {

    private String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0, j = B.length - 1; i < A.length; i++, j--) {
            if (A[i] + B[j] < k)    return "NO";
        }

        return "YES";
    }
}
