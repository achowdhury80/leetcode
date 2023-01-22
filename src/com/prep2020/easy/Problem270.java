package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem270 {
	/**
	 * O(N) time and space -- skew
	 * @param root
	 * @param target
	 * @return
	 */
	public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }
	
	private int helper(TreeNode root, double target, int prevClosest) {
		if (root == null) return prevClosest;
		if (root.val == target) return root.val;
		if (Math.abs(root.val - target) < Math.abs(prevClosest - target)) {
			prevClosest = root.val;
		}
		if (root.val > target) return helper(root.left, target, prevClosest);
		return helper(root.right, target, prevClosest);
	}
}
