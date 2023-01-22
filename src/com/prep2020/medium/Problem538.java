package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem538 {
	/**
	 * O(N) time & space
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
		if(root == null) return null;
        helper(root, new int[] {0});
        return root;
    }
	
	private void helper(TreeNode root, int[] val) {
		if (root.right != null) helper(root.right, val);
		root.val += val[0];
		val[0] = root.val;
		if (root.left != null) helper(root.left, val);
	}
}
