package com.prep2020.hard;

public class Problem25 {
	/**
	 * O(N) time and O(1) space
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while((cur = reverseNextK(cur, k)) != null);
        return dummy.next;
    }
	
	private ListNode reverseNextK(ListNode parent, int k) {
		ListNode cur = parent;
		int count = 0;
		while(cur.next != null) {
			cur = cur.next;
			count++;
			if (count == k) break;
		}
		if (count < k) return null;
		ListNode next = cur.next;
		ListNode result = parent.next;
		cur.next = null;
		ListNode reversed = reverse(parent.next);
		parent.next = reversed;
		result.next = next;
		return result;
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(-1);
		while(head != null) {
			ListNode temp = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = temp;
		}
		return dummy.next;
	}
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
