package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem234 {
	/**
	 * O(N) time
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode secondPart = slow.next;
        slow.next = null;
        ListNode reversed = reverse(secondPart);
        ListNode cur = head, reversedCur = reversed;
        boolean result = true;
        while(cur != null && reversedCur != null) {
        	if (cur.val != reversedCur.val) {
        		result = false;
        		break;
        	}
        	cur = cur.next;
        	reversedCur = reversedCur.next;
        }
        slow.next = reverse(reversed);
        return result;
    }

	private ListNode reverse(ListNode head) {
		ListNode dummy = new ListNode(-1);
		while(head != null) {
			ListNode temp = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = temp;
		}
		return dummy.next;
	}
}
