package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1448 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
	
	private int helper(TreeNode root, int maxVal) {
		int result = 0;
		if (root.val >= maxVal) result++;
		maxVal = Math.max(maxVal, root.val);
		if (root.left != null) result += helper(root.left, maxVal);
		if (root.right != null) result += helper(root.right, maxVal);
		return result;
	}
}
