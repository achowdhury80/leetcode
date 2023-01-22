package com.prep2020.medium;

public class Problem1666 {
	/**
	 * O(N)
	 * @param root
	 * @param leaf
	 * @return
	 */
	public Node flipBinaryTree(Node root, Node leaf) {
        return flip(leaf);
    }
	
	private Node flip(Node node) {
		if (node == null) return null;
		if (node.parent ==null) return node;
		if (node.left != null) {
			node.right = node.left;
			node.left = null;
		}
		Node parent = node.parent;
		if (parent.left == node) parent.left = null;
		else parent.right = null;
		Node flipped = flip(parent);
		flipped.parent = node;
		node.left = flipped;
		node.parent = null;
		return node;
	}
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	}
}
