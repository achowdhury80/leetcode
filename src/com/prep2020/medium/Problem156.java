package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem156 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		return helper(root)[0];
    }
	
	/**
	 * 0th element is root and first element is the right most node
	 * @param root
	 * @return
	 */
	private TreeNode[] helper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) 
			return new TreeNode[] {root, root};
		TreeNode[] left = helper(root.left);
		left[1].right = root;
		left[1].left = root.right;
		root.left = null;
		root.right = null;
		return new TreeNode[] {left[0], left[1].right == null ? left[1] : left[1].right};
	}
}
