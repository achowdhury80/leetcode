package comp.prep2019;

import java.util.Random;

public class Prob382 {
	private ListNode head;
	private int len;
	private Random random;
	public Prob382(ListNode head) {
        this.head = head;
        random = new Random();
        len = 1;
        ListNode cur = head;
        while(cur.next != null) {
        	len++;
        	cur = cur.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0, idx = random.nextInt(len);
        ListNode cur = head;
        while(count < idx) {
        	cur = cur.next;
        	count++;
        }
        return cur.val;
    }
}
