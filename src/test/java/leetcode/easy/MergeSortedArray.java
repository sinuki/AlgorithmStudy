package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 **/
public class MergeSortedArray {

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;

        for (int i = m, j = 0; i < length; i++, j++) {
            nums1[i] = nums2[j];
        }

        Arrays.sort(nums1);
    }
}
