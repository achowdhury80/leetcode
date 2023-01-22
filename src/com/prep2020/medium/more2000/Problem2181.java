package com.prep2020.medium.more2000;

import com.prep2020.ListNode;

public class Problem2181 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode cur = head.next;
        int sum = 0;
        while(cur != null) {
        	sum += cur.val;
        	if (cur.val == 0) {
        		temp.next = new ListNode(sum);
        		temp = temp.next;
        		sum = 0;
        	}
        	cur = cur.next;
        }
        
        return dummy.next;
    }
}
