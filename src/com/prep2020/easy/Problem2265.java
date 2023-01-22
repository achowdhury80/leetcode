package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem2265 {
	public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	private int[] helper(TreeNode root, int[] result) {
		if (root.left == null && root.right == null) {
			result[0]++;
			return new int[] {root.val, 1};
		}
		int[] left = new int[2], right = new int[2];
		if (root.left != null) left = helper(root.left, result);
		if (root.right != null) right = helper(root.right, result);
		int sum = root.val + left[0] + right[0], count = 1 + left[1] + right[1];
		if (root.val == sum / count) result[0]++;
		return new int[] {sum, count};
	}
}
