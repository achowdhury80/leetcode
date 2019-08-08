package com.leet.algo;
import java.util.*;
public class Prob426 {
	public Node treeToDoublyList(Node root) {
		if (root == null) return null;
        Node head = new Node(-1, null, null);
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        Node list = head;
        while(!stack.isEmpty()) {
        	Node node = stack.pop();
        	node.left = list;
        	cur = node.right;
    		while(cur != null) {
    			stack.push(cur);
    			cur = cur.left;
    		}
    		list.right = node;
    		list = list.right;
        }
        list.right = head.right;
        head.right.left = list;
        return head.right;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	}
}
