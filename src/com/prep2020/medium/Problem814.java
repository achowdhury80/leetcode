package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem814 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }
	
	private TreeNode prune(TreeNode root) {
		if (root == null) return null;
		root.left = prune(root.left);
		root.right = prune(root.right);
		if (root.val == 0 && root.left == null && root.right == null) return null;
		return root;
	}
}
