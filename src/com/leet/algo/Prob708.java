package com.leet.algo;

public class Prob708 {
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _next) {
	        val = _val;
	        next = _next;
	    }
	}
	public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);
        if (head == null) {
        	node.next = node;
        	return node;
        }
        Node cur = head;
        Node endNode = null;;
        do{
        	if (cur.val <= insertVal && cur.next.val > insertVal) {
        		node.next = cur.next;
        		cur.next = node;
        		return head;
        	}
        	if (cur.val > cur.next.val) endNode = cur;
        	cur = cur.next;
        } while(cur != head);
        if (endNode == null) {
        	endNode = head;
        }
        node.next = endNode.next;
        endNode.next = node;
        return head;
    }
}
