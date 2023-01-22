package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem160 {
	/**
	 * O(m + n)
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLength(headA), lenB = findLength(headB);
        ListNode bigger = headA, smaller = headB;
        if (lenB > lenA) {
        	bigger = headB;
        	smaller = headA;
        }
        for (int i = 0; i < Math.abs(lenB - lenA); i++) {
        	bigger = bigger.next;
        }
        while(bigger != null && smaller != null) {
        	if (bigger == smaller) return bigger;
        	bigger = bigger.next;
        	smaller = smaller.next;
        }
        return null;
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
