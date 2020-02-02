package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 **/
public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode generate(int from, int to) {
        ListNode root = new ListNode(from);
        ListNode node = root;
        for (int i = from + 1; i <= to; i++) {
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = temp;
        }
        return root;
    }
    private ListNode reverseGenerate(int from, int to) {
        ListNode root = new ListNode(from);
        ListNode node = root;
        for (int i = from - 1; i >= to; i--) {
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = temp;
        }
        return root;
    }
    @Test
    public void test1() {
        ListNode root = generate(1, 5);
        ListNode reverseNode = reverseGenerate(5, 1);

        ListNode node = reverseList(root);
        ListNode expected = reverseNode;
        while (node != null) {
            assertEquals(expected.val, node.val);
            node = node.next;
            expected = expected.next;
        }
    }

    @Test
    public void test2() {
        assertEquals(null, reverseList(null));
    }
}
