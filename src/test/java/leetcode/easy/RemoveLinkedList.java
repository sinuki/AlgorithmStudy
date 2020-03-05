package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 **/
public class RemoveLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
           this.val = val;
        }
    }

    private ListNode removeElements(ListNode head, int val) {
        ListNode init = new ListNode(-1);
        init.next = head;
        ListNode node = head;
        ListNode prev = init;
        while (null != node) {
           if (node.val == val) {
               prev.next = node.next;
           } else {
               prev = node;
           }
           node = node.next;
        }
        return init.next;
    }

    @Test
    public void test1() {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        int[] expected = new int[] {1, 2, 3, 4, 5};
        ListNode actual = removeElements(root, 6);
        for (int val : expected) {
           assertEquals(val, actual.val);
           actual = actual.next;
        }
    }

    @Test
    public void test2() {
       assertNull(removeElements(new ListNode(1), 1));
    }
}
