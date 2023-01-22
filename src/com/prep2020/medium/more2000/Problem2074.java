package com.prep2020.medium.more2000;

import com.prep2020.ListNode;
public class Problem2074 {
	public ListNode reverseEvenLengthGroups(ListNode head) {
        int size = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int length = findLength(head), traversed = 0;
        while(cur.next != null) {
        	size++;
        	if (traversed + size > length) {
        		size = length - traversed;
        	}
        	if (size % 2 == 0) reverse(cur, size);
        	cur = move(cur, size);
        	traversed += size;
        }
        return dummy.next;
    }
	
	private int findLength(ListNode head) {
		int result = 0;
		while(head != null) {
			result++;
			head = head.next;
		}
		return result;
	}
	private void reverse(ListNode parent, int size) {
		ListNode cur = parent.next, last = parent.next;
		ListNode dummy = new ListNode(-1);
		while(cur != null && size > 0) {
			ListNode temp = cur;
			cur = cur.next;
			temp.next = dummy.next;
			dummy.next = temp;
			size--;
		}
		parent.next = dummy.next;
		last.next = cur;
	}

	private ListNode move(ListNode cur, int size) {
		while(cur.next != null && size > 0) {
			cur = cur.next;
			size--;
		}
		return cur;
	}
	
	public static void main(String[] args) {
		Problem2074 problem = new Problem2074();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(5);
		ListNode result = problem.reverseEvenLengthGroups(head);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
