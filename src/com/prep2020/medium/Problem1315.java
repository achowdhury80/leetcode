package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1315 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int sumEvenGrandparent(TreeNode root) {
        return helper(root, false, false);
    }
	
	private int helper(TreeNode root, boolean isEvenGrand, boolean isEvenParent) {
		int result = 0;
		if (isEvenGrand) result += root.val;
		if (root.left != null) result += helper(root.left, isEvenParent, root.val % 2 == 0);
		if (root.right != null) result += helper(root.right, isEvenParent, root.val % 2 == 0);
		return result;
	}
}
