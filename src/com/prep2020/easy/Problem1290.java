package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem1290 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head != null) {
        	result = result * 2 + head.val;
        	head = head.next;
        }
        return result;
    }
}
