package comp.prep2019.less2000;

import comp.prep2019.ListNode;

public class Prob147 {
	/**
	 * consider a sorted list result
	 * it will have only the first node
	 * keep traversing the input list and update the sorted list
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = head.next, resultCur = result;
        result.next.next = null;
        while(cur != null) {
        	if (resultCur.next == null || cur.val <= resultCur.next.val) {
        		ListNode temp = resultCur.next;
        		resultCur.next = cur;
        		cur = cur.next;
        		resultCur = resultCur.next;
        		resultCur.next = temp;
        		resultCur = result;
        	} else {
        		resultCur = resultCur.next;
        	}
        }
        return result.next;
    }
}
