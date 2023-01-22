package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem337 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
	
	/**
	 * 1st element is max value with root and 2nd element is the max Value without root
	 * @param root
	 * @return
	 */
	public int[] helper(TreeNode root) {
		int[] result = new int[2];
		if (root == null) return result;
		int[] left = helper(root.left), right = helper(root.right);
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}
}
