package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 **/
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    // best solution
    // 시간복잡도 : n
    // 공간복잡도 : 1
    private boolean hasCycle(ListNode head) {
        if (head == null)   return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    // 내가 시도한 방법
    // 시간복잡도 : n
    // 공간복잡도 : n
//    private boolean hasCycle(ListNode head) {
//        if (head == null)   return false;
//        HashMap<ListNode, Integer> checker = new HashMap<>();
//        while (head.next != null) {
//            checker.merge(head, 1, Integer::sum);
//            if (1 < checker.get(head))  return true;
//            head = head.next;
//        }
//        return false;
//    }

    @Test
    public void test1() {
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        assertTrue(hasCycle(root));
    }

    @Test
    public void test2() {
        ListNode root = new ListNode(3);
        assertFalse(hasCycle(root));
    }

    @Test
    public void test3() {
        assertFalse(hasCycle(null));
    }
}
