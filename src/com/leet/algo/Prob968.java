package com.leet.algo;

public class Prob968 {
	/**
	 * https://leetcode.com/problems/binary-tree-cameras/solution/
	 * @param root
	 * @return
	 */
	public int minCameraCover(TreeNode root) {
        int[] d = solve(root);
        return Math.min(d[1], d[2]);
    }
	
	private int[] solve(TreeNode root) {
		if (root == null) return new int[] {0, 0, 99999};
		int[] l = solve(root.left);
		int[] r = solve(root.right);
		int mL12 = Math.min(l[1], l[2]);
		int mR12 = Math.min(r[1], r[2]);
		
		int d0 = l[1] + r[1];
		int d1 = Math.min(l[2] + mR12, mL12 + r[2]);
		int d2 = 1 + Math.min(l[0], mL12) + Math.min(r[0], mR12);
		return new int[] {d0, d1, d2};
	}
}
