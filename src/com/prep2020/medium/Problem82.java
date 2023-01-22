package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem82 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        int last = -101;
        ListNode cur = head, curDummy = dummy;
        while(cur != null) {
        	if (cur.val != last && (cur.next == null || cur.next.val != cur.val)) {
        		curDummy.next = cur;
        		curDummy = curDummy.next;
        	}
        	last = cur.val;
        	cur = cur.next;
        }
        curDummy.next = null;
        return dummy.next;
    }
}
