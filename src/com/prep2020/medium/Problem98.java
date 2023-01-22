package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem98 {
	public boolean isValidBST(TreeNode root) {
        return helper(root, -1l + Integer.MIN_VALUE, 1l + Integer.MAX_VALUE);
    }
	
	private boolean helper(TreeNode root, long min, long max) {
		if (root.val >= max || root.val <= min) return false;
		if (root.left != null && !helper(root.left, min, root.val)) return false;
		if (root.right != null && !helper(root.right, root.val, max)) return false;
		return true;
	}
}
