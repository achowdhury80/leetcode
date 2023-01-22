package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem86 {
	/**
	 * O(N)
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode smallerDummy = new ListNode(-1);
		ListNode otherDummy = new ListNode(-1);
		ListNode curSmaller = smallerDummy, curOther = otherDummy;
		while(head != null) {
			if (head.val < x) {
				curSmaller.next = head;
				curSmaller = curSmaller.next;
				head = head.next;
				curSmaller.next = null;
			} else {
				curOther.next = head;
				curOther = curOther.next;
				head = head.next;
				curOther.next = null;
			}
		}
		curSmaller.next = otherDummy.next;
		return smallerDummy.next;
    }
}
