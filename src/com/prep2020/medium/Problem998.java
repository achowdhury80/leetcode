package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem998 {
	/**
	 * O(H)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
        if (root.val < val) {
        	TreeNode node = new TreeNode(val);
        	node.left = root;
        	return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
