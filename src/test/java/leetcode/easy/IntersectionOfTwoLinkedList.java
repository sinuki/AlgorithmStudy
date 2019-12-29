package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 **/
public class IntersectionOfTwoLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    // 내가 푼 방식
    // 시간복잡도 : O(m + n)
    // 공간복잡도 : O(m or n)
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> mapper = new HashMap<>();
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            mapper.put(node1, node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            if (mapper.containsKey(node2)) {
                return mapper.get(node2);
            }
            node2 = node2.next;
        }
        return null;
    }
    // best solution
    // 시간복잡도 : O(m + n)
    // 공간복잡도 : O(1)
//    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;
//        ListNode node1 = headA;
//        ListNode node2 = headB;
//        while (node1 != node2) {
//            node1 = node1 == null ? headB : node1.next;
//            node2 = node2 == null ? headA : node2.next;
//            if (node1 == headA && node2 == headB) {
//                return null;
//            }
//        }
//        return node1;
//    }

    @Test
    public void null_테스트() {
        ListNode node2 = new ListNode(2);
        assertNull(getIntersectionNode(null, node2));
    }

    @Test
    public void 교차지점_테스트() {
        ListNode node = new ListNode(8);
        node.next = new ListNode(9);
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(1);
        node1.next.next = node;
        ListNode node2 = new ListNode(0);
        node2.next = node;
        assertEquals(node, getIntersectionNode(node1, node2));
    }
}
