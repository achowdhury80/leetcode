package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem1022 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int sumRootToLeaf(TreeNode root) {
        int[] result = new int[] {0};
        helper(root, 0, result);
        return result[0];
    }
	
	private void helper(TreeNode root, int prev, int[] result) {
		int val = ((prev << 1) | root.val);
		if (root.left == null && root.right == null) {
			result[0] += val;
			return;
		}
		if (root.left != null) helper(root.left, val, result);
		if (root.right != null) helper(root.right, val, result);
	}
}
