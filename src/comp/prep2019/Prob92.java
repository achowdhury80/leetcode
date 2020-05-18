package comp.prep2019;

public class Prob92 {
	/**
	 * find the parent of mth node;
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) return head;
		ListNode result = new ListNode(-1);
		result.next = head;
		ListNode cur = result;
		int i = 1;
		//find parent of mth node
		while(i < m) {
			cur = cur.next;
			i++;
		}
		// parent of mth Node
		ListNode parentOfMthNode = cur;
		// keep this node for future use
		ListNode reversedLast = cur.next;
		cur = parentOfMthNode.next;
		ListNode reversed = null;
		// reverse all mth to nth node
		while (i <= n) {
			ListNode temp = cur.next;
			cur.next = reversed;
			reversed = cur;
			cur = temp;
			i++;
		}
		//set the previously saved reversedLast next to cur
		reversedLast.next = cur;
		// set parentOfMthNode next to start of reversed
		parentOfMthNode.next = reversed;
		return result.next;
    }
	
}
