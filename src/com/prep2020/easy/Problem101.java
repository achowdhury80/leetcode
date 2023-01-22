package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem101 {
	/**
	 * O(N) time and o(H) space
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
        return helper(root.left, root.right);
    }
	
	private boolean helper(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) return true;
		if (node1 == null || node2 == null) return false;
		return node1.val == node2.val && helper(node1.left, node2.right) 
				&& helper(node1.right, node2.left);
	}
}
