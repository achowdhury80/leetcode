package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem687 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int longestUnivaluePath(TreeNode root) {
		int[] result = new int[1];
		helper(result, root);
		return result[0];
    }
	
	private int helper(int[] result, TreeNode root) {
		if (root == null) return 0;
		int left = helper(result, root.left);
		int ans = 1;
		if (root.left != null && root.left.val == root.val) ans += left;
		int right = helper(result, root.right);
		if (root.right != null && root.right.val == root.val)
			ans = Math.max(ans, 1 + right);
		result[0] = Math.max(result[0], ans - 1);
		if (root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val) {
			result[0] = Math.max(result[0], left + right);
		}
		
		return ans;
	}
}
