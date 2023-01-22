package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1145 {
	/**
	 * O(N)
	 * @param root
	 * @param n
	 * @param x
	 * @return
	 */
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = find(root, x);
        int leftSize = findTreeSize(xNode.left);
        if (2 * leftSize > n) return true;
        int rightSize = findTreeSize(xNode.right);
        if (2 * rightSize > n) return true;
        int xNodeSize = 1 + leftSize + rightSize;
        return 2 * xNodeSize < n;
    }
	
	private TreeNode find(TreeNode root, int x) {
		if (root == null) return null;
		if (root.val == x) return root;
		TreeNode left = find(root.left, x);
		if (left != null) return left;
		return find(root.right, x);
	}
	
	private int findTreeSize(TreeNode root) {
		if (root == null) return 0;
		return 1 + findTreeSize(root.left) + findTreeSize(root.right);
	}
}
