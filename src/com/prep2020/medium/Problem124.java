package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem124 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		int[] result = new int[] {root.val};
        helper(root, result);
        return result[0];
    }
	
	private int helper(TreeNode root, int[] result) {
		if (root.left == null && root.right == null) {
			result[0] = Math.max(result[0], root.val);
			return root.val;
		}
		int leftVal = 0, rightVal = 0;
		if (root.left != null) {
			leftVal = Math.max(leftVal, helper(root.left, result));
		}
		if (root.right != null) {
			rightVal = Math.max(rightVal, helper(root.right, result));
		}
		result[0] = Math.max(result[0], root.val + leftVal + rightVal);
		return root.val + Math.max(leftVal, rightVal);
	}
}
