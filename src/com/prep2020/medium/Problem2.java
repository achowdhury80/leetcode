package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem2 {
	/**
	 * O(m + n)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
        	int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        	cur.next = new ListNode(sum % 10);
        	carry = sum /10;
        	cur = cur.next;
        	if (l1 != null) l1 = l1.next;
        	if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
