package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem19 {
	/**
	 * O(N)
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        // find parent of nth node using i = 1
        for (int i = 0; i < n; i++) cur = cur.next;
        ListNode parent = dummy;
        while(cur.next != null) {
        	cur = cur.next;
        	parent = parent.next;
        }
        parent.next = parent.next.next;
        return dummy.next;
    }
}
