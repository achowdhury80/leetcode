package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem1721 {
	/**
	 * O(N)
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode swapNodes(ListNode head, int k) {
		ListNode node1 = null, node2 = null, cur = head;
		for (int i = 1; cur != null; i++) {
			if (i == k) {
				node1 = cur;
				node2 = head;
			} else if (node2 != null) node2 = node2.next;
			cur = cur.next;
		}
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
		return head;
    }
}
