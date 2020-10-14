package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob234 {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode secondPart = slow.next;
        ListNode reversed = reverse(secondPart);
        ListNode cur1 = head, cur2 = reversed;
        while(cur2 != null) {
        	if (cur1.val != cur2.val) return false;
        	cur1 = cur1.next;
        	cur2 = cur2.next;
        }
        return true;
    }
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode reversed = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		Prob234 prob = new Prob234();
		System.out.println(prob.isPalindrome(head));
	}
}
