package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob206 {
	/**
	 * O(N) time and O(1) space
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
