package com.leet.algo;

public class Prob510 {
	public Node inorderSuccessor(Node x) {
        if (x == null) return x;
        if (x.right != null) {
        	Node cur = x.right;
        	while(cur.left != null) cur = cur.left;
        	return cur;
        }
        Node parent = x.parent;
        while(parent != null) {
        	if (x == parent.left) break;
        	x = parent;
        	parent = x.parent;
        }
        return parent;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	}
}
