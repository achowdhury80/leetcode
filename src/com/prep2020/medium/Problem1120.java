package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1120 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public double maximumAverageSubtree(TreeNode root) {
        double[] result = new double[] {0.};
        findSumCount(root, result);
        return result[0];
    }
	
	public int[] findSumCount(TreeNode root, double[] result) {
		if (root == null) return new int[] {0, 0};
		int[] left = findSumCount(root.left, result);
		int[] right = findSumCount(root.right, result);
		int sum = left[0] + root.val + right[0];
		int count = left[1] + 1 + right[1];
		result[0] = Math.max(result[0], (sum + 0.) / count);
		return new int[] {sum, count};
	}
}
