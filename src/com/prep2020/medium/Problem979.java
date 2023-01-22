package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem979 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int distributeCoins(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	private int helper(TreeNode root, int[] result) {
		if (root == null) return 0;
		int left = helper(root.left, result);
		int right = helper(root.right, result);
		result[0] += Math.abs(left);
		result[0] += Math.abs(right);
		int val = left + right + root.val - 1;
		return val;
	}
}
