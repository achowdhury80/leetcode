package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem725 {
	/**
	 * O(N)
	 * @param root
	 * @param k
	 * @return
	 */
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		int length = findLength(root);
		ListNode cur = root;
		int idx = 0;
		int avg = length / k;
		int numberOfBigger = length - avg * k;
		while(cur != null) {
			result[idx++] = cur;
			for (int i = 0; i < avg - 1; i++) cur = cur.next;
			if (numberOfBigger > 0) {
				if (avg > 0) cur = cur.next;
				numberOfBigger--;
			}
			ListNode temp = cur.next;
			cur.next = null;
			cur = temp;
		}
		return result;
    }
	
	private int findLength(ListNode head) {
		int result = 0;
		while(head != null) {
			result++;
			head = head.next;
		}
		return result;
	}
}
