package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem701 {
	/*
	 * O(log H) where H is height
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
        if (root.val  > val) {
        	root.left = insertIntoBST(root.left, val);
        } else {
        	root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
