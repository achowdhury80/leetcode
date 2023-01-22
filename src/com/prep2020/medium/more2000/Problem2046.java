package com.prep2020.medium.more2000;

import com.prep2020.ListNode;

public class Problem2046 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode sortLinkedList(ListNode head) {
        ListNode negativeHead = new ListNode(-1), positiveHead = new ListNode(-1);
        ListNode cur = head, curPositive = positiveHead, negativeLast = null;
        while(cur != null) {
        	if(cur.val < 0) {
        		ListNode temp = cur;
        		cur = cur.next;
        		temp.next = negativeHead.next;
        		negativeHead.next = temp;
        		if (negativeLast == null) negativeLast = temp;
        	} else {
        		curPositive.next = cur;
        		cur = cur.next;
        		curPositive = curPositive.next;
        		curPositive.next = null;
        	}
        }
        if (negativeLast != null) {
        	negativeLast.next = positiveHead.next;
        	return negativeHead.next;
        } else return positiveHead.next;
    }
}
