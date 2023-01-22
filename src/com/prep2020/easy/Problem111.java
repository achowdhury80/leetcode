package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem111 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }
	
	private int helper(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int childDepth = Integer.MAX_VALUE;
        if (root.left != null) childDepth = Math.min(childDepth, minDepth(root.left));
        if (root.right != null) childDepth = Math.min(childDepth, minDepth(root.right));
        return 1 + childDepth;
    }
}
