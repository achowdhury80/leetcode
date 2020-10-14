package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob328 {
	/**
	 * O(N) time
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode oddHead = new ListNode(-1);
        oddHead.next = head;
        ListNode curOdd = head;
        ListNode evenHead = new ListNode(-1);
        evenHead.next = head.next;
        ListNode curEven = head.next;
        while(true) {
        	if (curOdd.next.next == null) break;
        	curOdd.next = curOdd.next.next;
        	curOdd = curOdd.next;
        	if (curEven.next.next == null) break;
        	curEven.next = curEven.next.next;
        	curEven = curEven.next;
        }
        curOdd.next = evenHead.next;
        curEven.next = null;
        return oddHead.next;
    }
}
