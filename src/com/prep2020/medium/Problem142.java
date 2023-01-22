package com.prep2020.medium;
import java.util.*;

import com.prep2020.ListNode;
public class Problem142 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        ListNode meetNode = null;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if (slow == fast) {
        		meetNode = slow;
        		break;
        	}
        }
        if (meetNode == null) return null;
        slow = head;
        while(slow != meetNode) {
        	slow = slow.next;
        	meetNode = meetNode.next;
        }
        return slow;
    }
}
