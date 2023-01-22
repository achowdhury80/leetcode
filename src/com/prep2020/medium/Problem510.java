package com.prep2020.medium;

public class Problem510 {
	/**
	 * O(H)
	 * @param node
	 * @return
	 */
	public Node inorderSuccessor(Node node) {
		Node cur;
        if (node.right != null) {
        	cur = node.right;
        	while(cur.left != null) cur = cur.left;
        	return cur;
        }
        Node parent = node.parent;
        cur = node;
        while(parent != null && parent.left != cur) {
        	cur = parent;
        	parent = cur.parent;
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
