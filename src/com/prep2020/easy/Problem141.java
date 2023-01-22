package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem141 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) return true;
        }
        return false;
    }
}
