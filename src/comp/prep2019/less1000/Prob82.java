package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob82 {
	/**
	 * use 3 pointer to keep track of prev, cur and next in the input list
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(-1), resultCur = result;
        ListNode prev = null, cur = head, next = cur.next;
        while(cur != null) {
        	if ((prev == null || prev.val != cur.val) && (next == null || next.val != cur.val)) {
        		resultCur.next = cur;
        		resultCur = resultCur.next;
        		resultCur.next = null;
        	}
        	prev = cur;
    		cur = next;
    		next = cur == null ? null : cur.next;
        	
        }
        return result.next;
    }
}
