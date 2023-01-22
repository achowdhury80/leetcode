package com.prep2020.medium.more2000;

public class Problem2095 {
	public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode parent = dummy;
        int count = 0, parentNext = 0;
        while(cur.next != null) {
        	cur = cur.next;
        	count++;
        	if (count / 2 > parentNext) {
        		parent = parent.next;
        		parentNext++;
        	}
        }
        ListNode next = parent.next.next;
        parent.next = next;
        return dummy.next;
    }
	
	class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
}
