package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem21 {
	/**
	 * O(n1 + n2)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
        	if (l1.val > l2.val) {
        		cur.next = l2;
        		l2 = l2.next;
        	} else {
        		cur.next = l1;
        		l1 = l1.next;
        	}
        	cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }
}
