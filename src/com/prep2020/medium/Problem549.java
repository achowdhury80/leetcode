package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem549 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	/**
	 * 0th element - starting root increasing path length
	 * 1th element - starting root decreasing path length
	 * @param root
	 * @param result
	 * @return
	 */
	private int[] helper(TreeNode root, int[] result) {
		int[] arr = new int[] {1, 1};
		int[] left = new int[2], right = new int[2];
		if (root.left != null) {
			left = helper(root.left, result);
			if (root.left.val + 1 == root.val) arr[1] += left[1];
			else if (root.left.val == root.val + 1) arr[0] += left[0];
		}
		if (root.right != null) {
			right = helper(root.right, result);
			if (root.right.val + 1 == root.val) arr[1] = Math.max(arr[1], 
					1 + right[1]);
			else if (root.right.val == root.val + 1) arr[0] 
					= Math.max(arr[0], 1 + right[0]);
		}
		int maxPath = Math.max(arr[0], arr[1]);
		if (root.left != null && root.right != null) {
			if (root.left.val + 1 == root.val 
					&& root.val + 1 == root.right.val)
				maxPath = Math.max(maxPath, 1 + left[1] + right[0]);
			else if (root.left.val - 1 == root.val 
					&& root.val - 1 == root.right.val)
				maxPath = Math.max(maxPath, 1 + left[0] + right[1]);
		}
		result[0] = Math.max(result[0], maxPath);
		return arr;
	}
}
