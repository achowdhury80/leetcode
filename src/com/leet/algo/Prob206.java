package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob206 {
  /*public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode reversed = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversed;
  }*/
  
  public ListNode reverseList(ListNode head) {
	    if (head == null) return null;
	    if (head.next == null) return head;
	    ListNode dummy = new ListNode(-1), cur = head;
	    while(cur != null) {
	    	ListNode temp = cur.next;
	    	cur.next = dummy.next;
	    	dummy.next = cur;
	    	cur = temp;
	    }
	    return dummy.next;
	  }
}
