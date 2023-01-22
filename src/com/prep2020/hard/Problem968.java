package com.prep2020.hard;

import com.prep2020.TreeNode;

public class Problem968 {
	/**
	 * https://leetcode.com/problems/binary-tree-cameras/solution/
	 * @param root
	 * @return
	 */
	public int minCameraCover(TreeNode root) {
        int[] result = solve(root);
        return Math.min(result[1], result[2]);
    }
	
	private int[] solve(TreeNode root) {
		if (root == null) return new int[] {0, 0, 9999};
		int[] left = solve(root.left);
		int[] right = solve(root.right);
		int mL12 = Math.min(left[1], left[2]), mR12 = Math.min(right[1], right[2]);
		
		int d0 = left[1] + right[1];
		int d1 = Math.min(left[2] + mR12, right[2] + mL12);
		int d2 = 1 + Math.min(left[0], mL12) + Math.min(right[0], mR12);
		return new int[] {d0, d1, d2};
	}
}
