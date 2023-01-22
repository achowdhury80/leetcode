package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem437 {
	/**
	 * O(N) time and O(H) space
	 * find paths including root
	 * find paths on the left without root
	 * find paths on the right without root
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
        	+ pathSumIncludingRoot(root, targetSum);
    }

	private int pathSumIncludingRoot(TreeNode root, long targetSum) {
		if (root == null) return 0;
		int result = 0;
		if (root.val == targetSum) result++;
		result += pathSumIncludingRoot(root.left, targetSum - root.val)
				+ pathSumIncludingRoot(root.right, targetSum - root.val);
		return result;
	}

	
}
