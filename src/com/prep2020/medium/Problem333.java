package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem333 {
	public int largestBSTSubtree(TreeNode root) {
		int[] result = new int[1];
		findBSTNMinMax(root, result);
		return result[0];
    }
	
	/**
	 * returns - 1st element size. -1 means not bst, 2nd element min and 3rd element is max
	 * @param root
	 * @param result
	 * @return
	 */
	private int[] findBSTNMinMax(TreeNode root, int[] result) {
		if (root == null) return new int[] {0, -1, -1};
		int[] left = findBSTNMinMax(root.left, result), right = findBSTNMinMax(root.right, result);
		int[] ret = new int[3];
		if (left[0] > -1 && right[0] > -1) {
			if ((left[0] == 0 || left[2] < root.val) && (right[0] == 0 || right[1] > root.val)) {
				ret[0] = 1 + left[0] + right[0];
				ret[1] = left[0] == 0 ? root.val : left[1];
				ret[2] = right[0] == 0 ? root.val : right[2]; 
				result[0] = Math.max(result[0], ret[0]);
			} else ret[0] = -1;
		} else ret[0] = -1;
		return ret;
	}
}
