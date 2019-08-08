package com.leet.algo;

public class Prob430 {
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
	public Node flatten(Node head) {
        if (head == null) return null;
        Node flatternedChild = flatten(head.child);
        head.child = null;
        Node next = head.next;
        Node cur = head;
        if (flatternedChild != null) {
        	head.next = flatternedChild;
        	flatternedChild.prev = head;
        	while(cur.next != null) cur = cur.next;
        }
        Node flatteredNext = flatten(next);
        cur.next = flatteredNext;
        if (flatteredNext != null) flatteredNext.prev = cur;
        return head;
    }
}
