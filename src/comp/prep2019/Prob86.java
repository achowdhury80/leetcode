package comp.prep2019;

public class Prob86 {
	/**
	 * create two dummy head - one for nonBigger and another for BiggerOrEqual
	 * set nonBigger next to input list head
	 * keep traversing through the list and remove equal or bigger and set that two biggerOrEqual set
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode nonBiggerDummy = new ListNode(-1);
        nonBiggerDummy.next = head;
        ListNode biggerDummy = new ListNode(-1);
        ListNode cur = nonBiggerDummy, curBigger = biggerDummy;
        while(cur.next != null) {
        	if (cur.next.val < x) cur = cur.next;
        	else {
        		curBigger.next = cur.next;
        		curBigger = curBigger.next;
        		cur.next = curBigger.next;
        		curBigger.next = null;
        	}
        }
        // if no smaller element found
        if (cur == nonBiggerDummy) return biggerDummy.next;
        cur.next = biggerDummy.next;
        return nonBiggerDummy.next;
    }
}
