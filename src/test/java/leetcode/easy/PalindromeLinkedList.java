package leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PalindromeLinkedList
 * author: sinuki
 * createdAt: 2020/02/09
 **/
public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    private boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        int middle = values.size() / 2;
        for (int i = 0, j = values.size() - 1; i < middle; i++, j--) {
            if (0 != values.get(i).compareTo(values.get(j))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void emptyTest() {
        assertTrue(isPalindrome(null));
    }

    @Test
    public void test1() {
        assertTrue(isPalindrome(new ListNode(1)));
    }

    @Test
    public void test2() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        assertFalse(isPalindrome(root));
    }

    @Test
    public void test3() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        assertTrue(isPalindrome(root));
    }
}
