package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem450 {
	/**
	 * O(H)
	 * @param root
	 * @param key
	 * @return
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
        	if (root.left == null) return root.right;
        	else if (root.right == null) return root.left;
        	TreeNode leftMost = findLeftMost(root.right);
        	leftMost.left = root.left;
        	return root.right;
        	
        } else if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }

	private TreeNode findLeftMost(TreeNode root) {
		while(root.left != null) root = root.left;
		return root;
	}
}
