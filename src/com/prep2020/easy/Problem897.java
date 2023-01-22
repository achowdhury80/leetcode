package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem897 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public TreeNode increasingBST(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * 1st element represents the root and last elements represents the last node
	 * @param root
	 * @return
	 */
	private TreeNode[] helper(TreeNode root) {
		TreeNode[] result = new TreeNode[] {root, root};
		if (root == null) return result;
		if (root.left != null) {
			result = helper(root.left);
			root.left = null;
			result[1].right = root;
			result[1] = root;
		} 
		if (root.right != null) {
			TreeNode[] right = helper(root.right);
			result[1].right = right[0];
			result[1] = right[1];
		}
		
		return result;
	}
}
