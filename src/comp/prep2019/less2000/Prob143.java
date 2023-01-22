package comp.prep2019.less2000;

public class Prob143 {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        //find mid
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        // reverse 2nd half. if odd number of nodes, then reverse smaller jhalf
        ListNode reversedCur = reverse(slow.next);
        slow.next = null;
        ListNode cur = head;
        while(reversedCur != null) {
        	ListNode temp = cur.next;
        	cur.next = reversedCur;
        	reversedCur = reversedCur.next;
        	cur.next.next = temp;
        	cur = temp;
        }
    }
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode reversed = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
	
	class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
}
