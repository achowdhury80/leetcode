package comp.prep2019;

public class Prob21 {
	/**
	 * O(n + m)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
        		cur.next = l1;
        		l1 = l1.next;
        	} else {
        		cur.next = l2;
        		l2 = l2.next;
        	}
        	cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;
        else cur.next = null;
        return dummy.next;
    }
}
