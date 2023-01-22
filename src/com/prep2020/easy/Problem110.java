package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem110 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
        return findDepth(root) != -1;
    }
	
	/**
	 * returns -1, if not heightBalanced
	 * @param root
	 * @return
	 */
	private int findDepth(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = findDepth(root.left);
		if (leftDepth == -1) return -1;
		int rightDepth = findDepth(root.right);
		if (rightDepth == -1) return -1;
		if (Math.abs(leftDepth - rightDepth) > 1) return -1;
		return 1 + Math.max(leftDepth, rightDepth);
	}
}
