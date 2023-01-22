package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem92 {
	/**
	 * O(N)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
        // find parent of mth node
		for (int i = 1; i < m; i++) {
			cur = cur.next;
		}
		ListNode mthNodeParent = cur;
		ListNode reversed = new ListNode(-1);
		cur = cur.next;
		ListNode temp = null;
		ListNode last = cur;
		for (int i = m; i <= n; i++) {
			temp = cur.next;
			cur.next = reversed.next;
			reversed.next = cur;
			cur = temp;
		}
		last.next = temp;
		mthNodeParent.next = reversed.next;
		return dummy.next;
    }
}
