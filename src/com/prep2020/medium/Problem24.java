package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem24 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode temp = head;
        while(head != null && head.next != null) {
        	temp = head.next.next;
        	cur.next = head.next;
        	cur = cur.next;
        	cur.next = head;
        	cur = cur.next;
        	cur.next = null;
        	head = temp;
        }
        if (temp != null) cur.next = temp;
        return dummy.next;
    }
}
