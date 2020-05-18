package comp.prep2019;

public class Prob148 {
	/**
	 * quick sort
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode smallerDummy = new ListNode(-1);
        ListNode smallerCur = smallerDummy;
        ListNode biggerDummy = new ListNode(-1);
        ListNode biggerCur = biggerDummy;
        ListNode pivot = head, cur = head.next;
        pivot.next = null;
        while(cur != null) {
        	if (cur.val >= pivot.val) {
        		biggerCur.next = cur;
        		biggerCur = biggerCur.next;
        		cur = cur.next;
        		biggerCur.next = null;
        	} else {
        		smallerCur.next = cur;
        		smallerCur = smallerCur.next;
        		cur = cur.next;
        		smallerCur.next = null;
        	}
        }
        ListNode result = sortList(smallerDummy.next);
        if (result == null) {
        	result = pivot;
        	cur = result;
        }
        else {
        	cur = result;
        	while(cur.next != null) cur = cur.next;
        	cur.next = pivot;
        	cur = cur.next;
        }
        cur.next = sortList(biggerDummy.next);
        return result;
    }
	
	public static void main(String[] args) {
		Prob148 prob = new Prob148();
		ListNode root = new ListNode(4);
		ListNode cur = new ListNode(2);
		root.next = cur;
		cur = root.next;
		cur.next = new ListNode(1);
		cur = cur.next;
		cur.next = new ListNode(3);
		ListNode result = prob.sortList(root);
		cur = result;
		while(cur != null) {
			System.out.print(cur.val + ", ");
			cur = cur.next;
		}
		
	}
}
