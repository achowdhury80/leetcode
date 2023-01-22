package com.prep2020.hard;
import java.util.*;
public class Problem23 {
	/**
	 * O(NLogK) time and O(k) space
	 * N is total number of elements and k is number of lists
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        Queue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode node : lists) {
        	if (node != null) pq.offer(node);
        }
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
        	ListNode node = pq.poll();
        	cur.next = new ListNode(node.val);
        	cur = cur.next;
        	node = node.next;
        	if (node != null) pq.offer(node);
        }
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
