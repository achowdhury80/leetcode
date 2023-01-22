package com.prep2020.medium;

import com.prep2020.ListNode;
import java.util.*;

public class Problem1019 {
	public int[] nextLargerNodes(ListNode head) {
		int[] count = new int[] {0};
        head = reverse(head, count);
        int[] result = new int[count[0]];
        Deque<Integer> dq = new ArrayDeque<>();
        ListNode cur = head;
        dq.offerLast(cur.val);
        int idx = result.length - 1;
        result[idx--] = 0;
        cur = cur.next;
        for (int i = idx; i > -1; i--) {
        	while(!dq.isEmpty() && dq.peekLast() <= cur.val) dq.pollLast();
        	if (!dq.isEmpty()) result[i] = dq.peekLast();
        	dq.offerLast(cur.val);
        	cur = cur.next;
        }
        head = reverse(head, new int[1]);
        return result;
    }
	private ListNode reverse(ListNode head, int[] count) {
		if (head.next == null) {
			count[0] = 1;
			return head;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
			cur = temp;
			count[0]++;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Problem1019 problem = new Problem1019();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		int[] result = problem.nextLargerNodes(head);
		System.out.println(result);
	}
}
