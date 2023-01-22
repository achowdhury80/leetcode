package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem226 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = left;
        return root;
    }
}
