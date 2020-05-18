package comp.prep2019;

public class Prob369 {
	public ListNode plusOne(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode cur = head;
        while(carry > 0 && cur != null) {
        	cur.val++;
        	if (cur.val < 10) carry = 0;
        	else cur.val %= 10;
        	cur = cur.next;
        }
        if (carry == 1) {
        	ListNode node = new ListNode(1);
        	node.next = head;
        	return node;
        }
        return reverse(head);
    }
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode reversed = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
		
	}
}
