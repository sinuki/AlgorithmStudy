package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 **/
public class MinimumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (0 == left || 0 == right)    return Math.max(left, right) + 1;   // 현재 노드에서 어느 한쪽 자식 노드가 없을 때, 더 깊은쪽의 깊이를 얻는다.
        return Math.min(left, right) + 1;                                   // 자식 노드가 모두 있을 경우, 더 얕은 쪽의 깊이를 얻는다.
    }

    @Test
    public void 노드가_NULL일떄() {
        assertEquals(0, minDepth(null));
    }

    @Test
    public void 노드가_NULL이_아니고_깊이가_1일때() {
        TreeNode root = new TreeNode(3);
        assertEquals(1, minDepth(root));
    }

    @Test
    public void 깊이가_2일때() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        assertEquals(2, minDepth(root));
    }

    @Test
    public void 깊이가_3일때() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(2, minDepth(root));
    }
}
