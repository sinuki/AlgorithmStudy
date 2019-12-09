package leetcode.easy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 **/
public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)   return Collections.emptyList();

        LinkedList<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
            }

            result.addFirst(list);
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(Collections.emptyList(), levelOrderBottom(null));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3));

        assertEquals(expected, levelOrderBottom(root));
    }
}
