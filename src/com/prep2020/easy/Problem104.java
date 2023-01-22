package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem104 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
