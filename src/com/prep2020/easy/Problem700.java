package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem700 {
	/**
	 * O(logN)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
