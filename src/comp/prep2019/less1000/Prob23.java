package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.ListNode;
public class Prob23 {
	/**
	 * o(NlogM) where N is the total number of elements across all lists and m is 
	 * the number of lists  
	 * Maintain a min queue that returns head of lowest valued node
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode node : lists) {
        	if (node != null) q.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(q.size() > 1) {
        	ListNode node = q.poll();
        	cur.next = node;
        	cur = cur.next;
        	if (node.next != null) q.offer(node.next);
        	cur.next = null;
        }
        if (!q.isEmpty()) cur.next = q.poll();
        return dummy.next;
    }
}
