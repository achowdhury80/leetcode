package comp.prep2019;

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
