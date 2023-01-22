package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem250 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int countUnivalSubtrees(TreeNode root) {
		int[] result = new int[1];
		isUniValue(result, root);
		return result[0];
    }
	
	private boolean isUniValue(int[] result, TreeNode root) {
		if (root == null) return true;
		if (root.left == null && root.right == null) {
			result[0]++;
			return true;
		}
		boolean isLeftUni = isUniValue(result, root.left);
		boolean isRightUni = isUniValue(result, root.right);
		if (isLeftUni && isRightUni) {
			if ((root.left == null || root.left.val == root.val)
					&& (root.right == null || root.right.val == root.val)) {
				result[0]++;
				return true;
			}
				
		}
		return false;
	}
}
