package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem1474 {
	/**
	 * O(length)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode cur = dummy;
        int mCount = 0, nCount = 0;
        while(cur.next != null) {
        	if (mCount < m) {
        		cur = cur.next;
        		mCount++;
        	}
        	else {
        		if (nCount < n) {
        			cur.next = cur.next.next;
        			nCount++;
        		} else {
        			mCount = 0;
        			nCount = 0;
        		}
        		
        	}
        }
        return dummy.next;
    }
}
