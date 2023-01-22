package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem783 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int minDiffInBST(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * 3 elements. 1st min diff, 2nd min val of the tree and 3rd max val of the tree
	 * @param root
	 * @return
	 */
	private int[] helper(TreeNode root) {
		int[] result = new int[] {Integer.MAX_VALUE, root.val, root.val};
		if (root.left != null) {
			int[] left = helper(root.left);
			result[1] = left[1];
			result[0] = Math.min(left[0], root.val - left[2]);
		}
		if (root.right != null) {
			int[] right = helper(root.right);
			result[2] = right[2];
			result[0] = Math.min(result[0], Math.min(right[0],right[1] - root.val));
		}
		return result;
	}
}
