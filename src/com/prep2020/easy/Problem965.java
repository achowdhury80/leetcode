package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem965 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }
	
	private boolean helper(TreeNode root, int val) {
		if (root.val != val) return false;
		if (root.left != null && !helper(root.left, val)) return false;
		if (root.right != null && !helper(root.right, val)) return false;
		return true;
	}
}
