package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1026 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int maxAncestorDiff(TreeNode root) {
        int[] result = new int[] {0};
        helper(root, root.val, root.val, result);
        return result[0];
    }
	
	private void helper(TreeNode root, int max, int min, int[] result) {
		int diff = Math.max(Math.abs(root.val - min), Math.abs(max - root.val));
		result[0] = Math.max(result[0], diff);
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);
		if (root.left != null) helper(root.left, max, min, result);
		if (root.right != null) helper(root.right, max, min, result);
	}
}
