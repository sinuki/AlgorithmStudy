package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 **/
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val =val;
        }
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null)   return true;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return 1 >= Math.abs(left - right) && isBalanced(node.left) && isBalanced(node.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null)   return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return Math.max(left, right) + 1;
    }

    @Test
    public void isBalacedBinaryTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertTrue(isBalanced(root));
    }

    @Test
    public void nullNodeIsBalancedBinaryTree() {
        assertTrue(isBalanced(null));
    }

    @Test
    public void oneNodeIsBalancedBinaryTree() {
        assertTrue(isBalanced(new TreeNode(1)));
    }

    @Test
    public void isNotBalancedBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        assertFalse(isBalanced(root));
    }
}
