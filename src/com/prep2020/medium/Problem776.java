package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem776 {
	/**
	 * O(N)
	 * @param root
	 * @param V
	 * @return
	 */
	public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[] {null, null};
        TreeNode[] result = new TreeNode[2];
        if (root.val == V) {
        	result[1] = root.right;
        	root.right = null;
        	result[0] = root;
        	return result;
        }
        if (root.val > V) {
        	TreeNode[] sub = splitBST(root.left, V);
        	root.left = sub[1];
        	result[0] = sub[0];
        	result[1] = root;
        	return result;
        }
        
        TreeNode[] sub = splitBST(root.right, V);
    	root.right = sub[0];
    	result[0] = root;
    	result[1] = sub[1];
    	return result;
    }
}
