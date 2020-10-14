package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob25 {
	/**
	 * O(N) time and O(1) space
	 * in a loop, find kth node starting from cur
	 * reverse the nodes within cur and kth node
	 * update cur to point next of kth
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        // this node contains the last node of last reversed set
        ListNode last = dummy;
        while(true) {
        	// find kth node starting from cur
        	ListNode kthNode = findKthNodes(cur, k);
        	// if less than k nodes, don't reverse
        	if (kthNode == null) {
        		last.next = cur;
        		return dummy.next;
        	}
        	// keep the k+1 th node handy for later use
        	ListNode temp = kthNode.next;
        	// reverse nodes from cur to kthNode, so that cur become last node and
        	// kth node becomes first node
        	reverse(cur, kthNode);
        	// update last next and last itself.
        	last.next = kthNode;
        	last = cur;
        	cur = temp;
        }
    }
	
	//find kth node starting from cur
	// return null if there is less than k node left
	private ListNode findKthNodes(ListNode head, int k) {
		if (head == null) return null;
		ListNode cur = head;
		int i = 0;
		while(i < k - 1 && cur != null) {
			cur = cur.next;
			i++;
		}
		if (i < k - 1) return null;
		return cur;
	}
	
	//rewire to set links from tail to head. avoid recursion to reduce space.
	private void reverse(ListNode head, ListNode tail) {
		if (head == tail) return;
		ListNode result = null;
		ListNode cur = head;
		do {
			ListNode temp = cur.next;
			cur.next = result;
			result = cur;
			cur = temp;
		} while(cur != tail);
		tail.next = result;
	}
	
	public static void main(String[] args) {
		Prob25 prob = new Prob25();
		ListNode head = new ListNode(1);
		ListNode cur;
		head.next = (cur = new ListNode(2));
		cur.next = (cur = new ListNode(3));
		cur.next = (cur = new ListNode(4));
		cur.next = (cur = new ListNode(5));
		ListNode result = prob.reverseKGroup(head, 2);
		cur = result;
		while(cur != null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
	}
}
