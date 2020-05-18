package comp.prep2019;

public class Prob61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;
        ListNode cur = head;
        int n = 1;
        while(cur.next != null) {
        	cur = cur.next;
        	n++;
        }
        ListNode tail = cur;
        k %= n;
        k = n - k;
        cur = head;
        while(k > 1) {
        	cur = cur.next;
        	k--;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}
