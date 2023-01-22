package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem148 {
	/**
	 * O(NlogN)
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		return helper(head);
    }
	
	private ListNode helper(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode secondPart = slow.next;
		slow.next = null;
		return merge(helper(head), helper(secondPart));
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(head1 != null || head2 != null) {
			if (head2 == null || (head1 != null && head1.val < head2.val)) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
