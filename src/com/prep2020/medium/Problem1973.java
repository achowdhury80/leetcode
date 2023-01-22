package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1973 {
	/**
	 * O(N) time and O(h) space
	 * @param root
	 * @return
	 */
	public int equalToDescendants(TreeNode root) {
		int[] result = new int[1];
		findSubTreeSum(result, root);
		return result[0];
    }
	
	private int findSubTreeSum(int[] result, TreeNode root) {
		int descendantSum = root.left == null ? 0 : findSubTreeSum(result, 
				root.left);
		descendantSum += root.right == null ? 0 : findSubTreeSum(result, 
				root.right);
		if (root.val == descendantSum) result[0]++;
		return root.val + descendantSum;
	}
}
