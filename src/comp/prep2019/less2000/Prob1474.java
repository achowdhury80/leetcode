package comp.prep2019.less2000;

import comp.prep2019.ListNode;

public class Prob1474 {
	/**
	 * o(N)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode last = new ListNode(-1);
        last.next = head;
        int i = 0;
        while(last.next != null) {
        	if (i % 2 == 0) last = update(last, m, true);
        	else last = update(last, n, false);
        	i++;
        }
        return head;
    }
	
	private ListNode update(ListNode last, int x, boolean keep) {
		if (!keep) {
			ListNode cur = last;
			for (int i = 0; i < x && cur.next != null; i++) {
				cur = cur.next;
			}
			last.next = cur.next;
			return last;
		} else {
			ListNode cur = last;
			for (int i = 0; i < x && cur.next != null; i++) {
				cur = cur.next;
			}
			return cur;
		}
	}
}
