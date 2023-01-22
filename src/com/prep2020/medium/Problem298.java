package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem298 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];
        findLongestConsecutiveIncludingRoot(root, result);
        return result[0];
    }
	
	private int findLongestConsecutiveIncludingRoot(TreeNode root, int[] result) {
		if (root == null) return 0;
		int left = findLongestConsecutiveIncludingRoot(root.left, result);
		int right = findLongestConsecutiveIncludingRoot(root.right, result);
		int retVal = 1;
		if (root.left != null && root.left.val == root.val + 1) {
			retVal += left;
		}
		if (root.right != null && root.right.val == root.val + 1) {
			retVal = Math.max(retVal, 1 + right);
		}
		result[0] = Math.max(result[0], retVal);
		return retVal;
	}
}
