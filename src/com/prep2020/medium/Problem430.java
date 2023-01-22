package com.prep2020.medium;

public class Problem430 {
	public Node flatten(Node head) {
        return helper(head)[0];
    }
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	private Node[] helper(Node head) {
		if (head == null) return new Node[2];
		Node[] next = helper(head.next); 
		head.next = null;
		Node[] result = new Node[] {head, head};
		
		if (head.child != null) {
			Node[] childFlatten = helper(head.child);
			head.child = null;
			head.next = childFlatten[0];
			childFlatten[0].prev = head;
			result[1] = childFlatten[1];
		}
		if (next[0] != null) {
			result[1].next = next[0];
			next[0].prev = result[1];
			result[1] = next[1];
		}
		return result;
	}
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	}
}
