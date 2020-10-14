package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob141 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if (fast == slow) return true;
        }
        return false;
    }
}
