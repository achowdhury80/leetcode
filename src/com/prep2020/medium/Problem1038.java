package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1038 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public TreeNode bstToGst(TreeNode root) {
        helper(root, new int[] {0});
        return root;
    }
	
	private void helper(TreeNode root, int[] valToAdd) {
		if (root.right != null) helper(root.right, valToAdd);
		root.val += valToAdd[0];
		valToAdd[0] = root.val;
		if (root.left != null) helper(root.left, valToAdd);
	}
}
