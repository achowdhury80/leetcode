package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem563 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        findSubTreeSum(root, result);
        return result[0];
    }
	
	private int findSubTreeSum(TreeNode root, int[] result) {
		int sum = root.val;
		int left = 0, right = 0;
		if (root.left != null) left = findSubTreeSum(root.left, result);
		if (root.right != null) right = findSubTreeSum(root.right, result);
		sum += left + right;
		result[0] += Math.abs(left -right);
		return sum;
	}
}
