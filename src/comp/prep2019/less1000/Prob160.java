package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob160 {
	/**
	 * O(m + n)
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int aLen = findLength(headA), bLen = findLength(headB);
        ListNode curA = headA, curB = headB;
        while(aLen > bLen) {
        	curA = curA.next;
        	aLen--;
        }
        while(bLen > aLen) {
        	curB = curB.next;
        	bLen--;
        }
        while (curA != null) {
        	if (curA == curB) return curA;
        	curA = curA.next;
        	curB = curB.next;
        }
        return null;
    }
	
	private int findLength(ListNode head) {
		int result = 0;
		while(head != null) {
			result++;
			head = head.next;
		}
		return result;
	}
}
