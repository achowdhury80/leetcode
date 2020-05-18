package comp.prep2019;

public class Prob142 {
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        if(head.next == head) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) break;
        }
        if (fast.next == null || fast.next.next == null) return null;
        slow = head;
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
}
