package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 **/
public class RemoveDuplicatesFromSortedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    @Test
    public void test() {
        ListNode test = new ListNode(1);
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        test.next = test1;
        test1.next = test2;

        ListNode result = deleteDuplicates(test);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
    }
}
