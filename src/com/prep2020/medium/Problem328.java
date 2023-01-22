package com.prep2020.medium;

import com.prep2020.ListNode;

public class Problem328 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1), evenDummy = new ListNode(-1);
        ListNode curOdd = oddDummy, curEven = evenDummy;
        int i = 1;
        while(head != null) {
        	if (i % 2 == 1) {
        		curOdd.next = head;
        		curOdd = curOdd.next;
        	} else {
        		curEven.next = head;
        		curEven = curEven.next;
        	}
        	head = head.next;
        	i++;
        }
        curOdd.next = evenDummy.next;
        curEven.next = null;
        return oddDummy.next;
    }
}
