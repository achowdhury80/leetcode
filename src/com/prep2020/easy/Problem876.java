package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem876 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return slow;
    }
}
