package comp.prep2019;

public class Prob430 {
	public Node flatten(Node head) {
		if (head == null) return head;
		Node temp = flatten(head.next);
		if (head.child != null) {
			Node childHead = flatten(head.child);
			head.child = null;
			head.next = childHead;
			childHead.prev = head;
			Node cur = head;
			while(cur.next != null) cur = cur.next;
			cur.next = temp;
			if(temp != null) temp.prev = cur;
		} else {
			head.next = temp;
			if(temp != null) temp.prev = head;
		}
		return head;
    }
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}
}
