package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    int max = Integer.MIN_VALUE;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        find(root);
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private void find(TreeNode node) {
        if (null == node) return;
        find(node.left);
        find(node.right);
        int count = map.getOrDefault(node.val, 0) + 1;
        max = Math.max(max, count);
        map.put(node.val, count);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        int[] expected = new int[] {2};
        assertArrayEquals(expected, findMode(root));
    }
}
