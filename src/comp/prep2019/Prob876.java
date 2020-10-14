package comp.prep2019;

public class Prob876 {
	/**
	 * O(N)
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return slow;
    }
}
