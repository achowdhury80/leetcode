package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem1669 {
	/**
	 * O(N)
	 * @param list1
	 * @param a
	 * @param b
	 * @param list2
	 * @return
	 */
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode dummy = new ListNode(-1);
		dummy.next = list1;
        ListNode cur = dummy;
        ListNode aNodePrev = null, bNode = null;
        for (int i = 0; aNodePrev == null || bNode == null; i++) {
        	if (i == a) aNodePrev = cur;
        	if (i == b) bNode = cur.next;
        	cur = cur.next;
        }
        aNodePrev.next = list2;
        cur = list2;
        while(cur.next != null) cur = cur.next;
        cur.next = bNode.next;
        return dummy.next;
    }
	
	
}
