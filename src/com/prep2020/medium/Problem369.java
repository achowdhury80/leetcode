package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem369 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        while(true) {
        	cur.val++;
        	if (cur.val < 10) break;
        	else if (cur.next == null) {
        		cur.next = new ListNode(1);
                cur.val = 0;
        		break;
        	} else {
        		cur.val = 0;
        		cur = cur.next;
        	}
        }
        head = reverse(head);
        return head;
        
    }
	
	private ListNode reverse(ListNode head) {
		if (head.next == null) return head;
		ListNode dummy = new ListNode(-1);
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
			cur = temp;
		}
		return dummy.next;
	}
}
