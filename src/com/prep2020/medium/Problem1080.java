package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1080 {
	public TreeNode sufficientSubset(TreeNode root, int limit) {
		if (root == null) return root;
		TreeNode dummy = new TreeNode(-1);
		dummy.left = root;
        if (isInsufficient(root, dummy, 0, limit)) return null;
        return dummy.left;
    }
	
	private boolean isInsufficient(TreeNode root, TreeNode parent, int curSum, int limit) {
		curSum += root.val;
		if (root.left == null && root.right == null) {
			if (curSum < limit) {
				if (parent.left == root) parent.left = null;
				else parent.right = null;
				return true;
			}
			return false;
		}
		boolean isLeftInsufficient = root.left == null || isInsufficient(root.left, root, curSum, limit);
		boolean isRightInsufficient = root.right == null || isInsufficient(root.right, root, curSum , limit);
		if (isLeftInsufficient && isRightInsufficient) {
			if (parent.left == root) parent.left = null;
			else parent.right = null;
			return true;
		}
		return false;
	}
}
