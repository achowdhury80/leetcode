package comp.prep2019;

import java.util.Random;

public class Prob382 {
	private ListNode head;
	  Random random;
	  public Prob382(ListNode head) {
	    this.head = head;
	    random = new Random();
	  }

	  /** Returns a random node's value. */
	  public int getRandom() {
	    ListNode current = head;
	    int result = current.val;
	    for(int i = 1; current.next != null; i++){
	      current = current.next;
	      if(random.nextInt(i + 1) == i) result = current.val;
	    }
	    return result;
	  }
}
