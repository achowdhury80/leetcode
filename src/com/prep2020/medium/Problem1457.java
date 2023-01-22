package com.prep2020.medium;

import java.util.Arrays;

import com.prep2020.TreeNode;

public class Problem1457 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int pseudoPalindromicPaths (TreeNode root) {
        boolean[] single = new boolean[10];
        return helper(root, single);
    }
	
	private int helper(TreeNode root, boolean[] single) {
		single[root.val] = !single[root.val];
		if (root.left == null && root.right == null) return isPalindromic(single) ? 1 : 0;
		int result = 0;
		if (root.left != null) result += helper(root.left, Arrays.copyOf(single, single.length));
		if (root.right != null) result += helper(root.right, Arrays.copyOf(single, single.length));
		return result;
	}
	
	private boolean isPalindromic(boolean[] single)  {
		int count = 0;
		for (boolean val : single) {
			if (val) count++;
			if (count > 1) return false;
		}
		return true;
	}
}
