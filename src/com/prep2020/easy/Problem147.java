package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem147 {
	/**
	 * O(N^2)
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
        	ListNode temp = head;
        	head = head.next;
        	temp.next = null;
        	dummy.next = addToList(dummy.next, temp);
        }
        return dummy.next;
    }
	
	private ListNode addToList(ListNode head, ListNode node) {
		if (head == null) return node;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next != null) {
			if (cur.next.val > node.val) {
				node.next = cur.next;
				cur.next = node;
				return dummy.next;
			}
			cur = cur.next;
		}
		cur.next = node;
		return dummy.next;
	}
}
