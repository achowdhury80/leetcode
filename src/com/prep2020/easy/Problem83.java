package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem83 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        if (head == null) return null;
        ListNode cur = dummy;
        cur.next = head;
        head = head.next;
        cur = cur.next;
        while(head != null) {
        	if (head.val != cur.val) {
        		cur.next = head;
        		cur = cur.next;
        	}
        	head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
