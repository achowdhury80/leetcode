package com.prep2020.easy;

public class Problem426 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        return helper(root)[0];
    }
	
	/**
	 * 1st element points to first node while 2nd element points to last node
	 * @param root
	 * @return
	 */
	private Node[] helper(Node root) {
		Node[] result = new Node[] {root, root};
		if (root == null) return result;
		Node[] left = helper(root.left);
		if (left[0] != null) {
			left[1].right = root;
			root.left = left[1];
			result[0] = left[0];
		}
		Node[] right = helper(root.right);
		if (right[0] != null) {
			right[0].left = root;
			root.right = right[0];
			result[1] = right[1];
		}
		result[0].left = result[1];
		result[1].right = result[0];
		return result;
	}
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	}
}
