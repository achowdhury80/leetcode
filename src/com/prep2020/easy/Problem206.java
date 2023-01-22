package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem206 {
	/**
	 * O(N) time
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
        	ListNode temp = head;
        	head = head.next;
        	temp.next = dummy.next;
        	dummy.next = temp;
        }
        return dummy.next;
    }
}
