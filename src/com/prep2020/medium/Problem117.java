package com.prep2020.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem117 {
	public Node connect(Node root) {
		if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	Node temp = new Node();
        	for (int i = 0; i < size; i++) {
        		temp.next = q.poll();
        		temp = temp.next;
        		if (temp.left != null) q.offer(temp.left);
        		if (temp.right != null) q.offer(temp.right);
        	}
        }
        return root;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
}
