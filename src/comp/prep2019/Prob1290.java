package comp.prep2019;

public class Prob1290 {
	/**
	 * O(N) time and O(1) space
	 * reverse the linkedlist
	 * compute the val 
	 * @param head
	 * @return
	 */
	public int getDecimalValue(ListNode head) {
		int result = 0;
		while(head != null) {
			result = (result << 1) | head.val;
			head = head.next;
		}
		return result;
	}
	public int getDecimalValue1(ListNode head) {
		ListNode rev = reverse(head);
		int result = 0, pow = 1; 
		while(rev != null) {
			result += pow * rev.val;
			rev = rev.next;
			pow *= 2;
		}
		return result;
    }
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode result = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}
}
