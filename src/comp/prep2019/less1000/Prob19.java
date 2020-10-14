package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob19 {
	//one pass
	// keep track of nth element from last visited
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode parent = dummy;
        for (int i = 0; i < n; i++) cur = cur.next;
        while(cur.next != null) {
        	cur = cur.next;
        	parent = parent.next;
        }
        parent.next = parent.next.next;
        return dummy.next;
    }
}
