package com.prep2020.medium;

import com.prep2020.TreeNode;
public class Problem1372 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int longestZigZag(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0] - 1;
    }
	
	/**
	 * 0th element = starting from root and going left
	 * 1st element = starting from root and going right
	 * @param root
	 * @param result
	 * @return
	 */
	private int[] helper(TreeNode root, int[] result) {
		int[] retVal = new int[2];
		if (root == null) return retVal;
		int[] left = helper(root.left, result);
		int[] right = helper(root.right, result);
		int leftPath = 1 + left[1], rightPath = 1 + right[0];
		result[0] = Math.max(result[0], Math.max(leftPath, rightPath));
		return new int[] {leftPath, rightPath};
	}
}
