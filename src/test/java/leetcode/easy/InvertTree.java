package leetcode.easy;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 **/
public class InvertTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode invertTree(TreeNode root) {
        if (null == root) return  root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
