package comp.prep2019.less1000;


public class Prob729 {
	private ListNode dummy;
	public Prob729() {
        dummy = new ListNode(-1, -1);
    }
    
    public boolean book(int start, int end) {
        ListNode cur = dummy;
        while(cur.next != null && cur.next.end <= start) {
        	cur = cur.next;
        }
        if (cur.next == null) {
        	cur.next = new ListNode(start, end);
        	return true;
        }
        if (cur.next.start >= end ) {
        	ListNode temp = new ListNode(start, end);
        	temp.next = cur.next;
        	cur.next = temp;
        	return true;
        }
        return false;
    }
    
    class ListNode {
        int start;
        int end;
        ListNode next;

        public ListNode(int start, int end) {
          this.start = start;
          this.end = end;
        }
      }
}
