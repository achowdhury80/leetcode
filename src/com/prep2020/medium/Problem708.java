package com.prep2020.medium;

public class Problem708 {
	public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        node.next = node;
        if (head == null) return node;
        if (head.next == head) {
        	head.next = node;
        	node.next = head;
        	return node;
        }
        Node cur = head;
        Node maxNode = null;
        do {
        	if (cur.val == node.val || cur.val < node.val && cur.next.val >= node.val) {
        		node.next = cur.next;
        		cur.next = node;
        		return node;
        	} else if (cur.val > cur.next.val) {
        		maxNode = cur;
        	}
        	cur = cur.next;
        } while(cur != head);
        if (maxNode == null) {
        	node.next = head;
        	head.next = node;
        	return node;
        } else {
        	node.next = maxNode.next;
        	maxNode.next = node;
        	return node;
        }
    }
	
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _next) {
	        val = _val;
	        next = _next;
	    }
	}
}
