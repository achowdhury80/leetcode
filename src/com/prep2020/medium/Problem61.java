package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) return head;
        int[] count = new int[1];
        ListNode last = findLastNode(head, count);
        k = k % count[0];
        if (k == 0 || count[0] == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < count[0] - k; i++) cur = cur.next;
        last.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
	
	private ListNode findLastNode(ListNode head, int[] count) {
		ListNode last = null;
		while(head != null) {
			count[0]++;
			last = head;
			head = head.next;
		}
		return last;
	}
}
