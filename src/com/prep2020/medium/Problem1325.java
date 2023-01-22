package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1325 {
	/**
	 * O(N) time and space
	 * @param root
	 * @param target
	 * @return
	 */
	public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeaves(root, target);
    }
	
	private TreeNode removeLeaves(TreeNode root, int target) {
		if (root == null) return null;
		root.left = removeLeaves(root.left, target);
		root.right = removeLeaves(root.right, target);
		if (isLeaf(root) && root.val == target) return null;
		return root;
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
}
