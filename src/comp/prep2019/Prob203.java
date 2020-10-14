package comp.prep2019;

public class Prob203 {
	/*
	 * O(N)
	 */
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null) {
        	if (cur.next.val == val) {
        		cur.next = cur.next.next;
        	} else {
        		cur = cur.next;
        	}
        }
        return dummy.next;
    }
}
