package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem203 {
	/**
	 * O(N)
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null) {
        	if (cur.next.val == val) {
        		cur.next = cur.next.next;
        	} else cur = cur.next;
        }
        return dummy.next;
    }
}
