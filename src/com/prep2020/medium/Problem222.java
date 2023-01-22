package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem222 {
	/**
	 * O(logN)
	 * @param root
	 * @return
	 */
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if (leftHeight > rightHeight) {
        	return 1 + ((int)Math.pow(2, rightHeight) - 1) 
        			+ countNodes(root.left);
        } else {
        	return 1 + ((int)Math.pow(2, leftHeight) - 1) 
        			+ countNodes(root.right);
        }
    }
	
	private int findHeight(TreeNode root) {
		if (root == null) return 0;
		return 1 + findHeight(root.left);
	}
}
