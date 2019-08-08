package com.leet.algo;

public class Prob876 {
	public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        if(fast.next != null) return slow.next;
        return slow;
    }
}
