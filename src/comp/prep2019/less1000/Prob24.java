package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode temp1 = swapPairs(head.next.next), temp2 = head.next;
        temp2.next = head;
        head.next = temp1;
        return temp2;
    }
}
