package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem112 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
        if (isLeaf(root)) return root.val == sum;
        return (root.left != null ? hasPathSum(root.left, sum - root.val) : false)
        		|| (root.right != null ? hasPathSum(root.right, sum - root.val) : false);
    }
	
	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
}
