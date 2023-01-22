package com.prep2020.medium.more2000;

import com.prep2020.ListNode;

public class Problem2130 {
	public int pairSum(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        ListNode cur1 = head, cur2 = reversed;
        int result = cur1.val + cur2.val;
        while(cur1.next != null) {
        	cur1 = cur1.next;
        	cur2 = cur2.next;
        	result = Math.max(result, cur1.val + cur2.val);
        }
        return result;
    }

	private ListNode reverse(ListNode head) {
		ListNode dummy = new ListNode(-1);
		while(head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = dummy.next;
			dummy.next = temp;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Problem2130 problem = new Problem2130();
		ListNode head = new ListNode(1);
		head.next = new ListNode(100000);
		System.out.println(problem.pairSum(head));
	}
}
