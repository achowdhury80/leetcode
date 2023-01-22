package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem143 {
	/**
	 * O(N)
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head.next == null || head.next.next == null) return;
        ListNode middle = findMiddleNode(head);
        ListNode reversed = reverse(middle.next);
        middle.next = null;
        ListNode cur = head;
        while(reversed != null) {
        	ListNode temp = cur.next;
        	cur.next = reversed;
        	reversed = reversed.next;
        	cur.next.next = temp;
        	cur = temp;
        }
    }
	
	private ListNode findMiddleNode(ListNode head) {
		ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return slow;
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(-1);
		while(head != null) {
			ListNode temp = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = temp;
		}
		return dummy.next;
	}
}
