package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1676 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param nodes
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		if (root == null) return null;
		for (TreeNode node : nodes) {
			if (node == root) return node;
		}
        TreeNode leftAncestor = lowestCommonAncestor(root.left, nodes), 
        		rightAncestor = lowestCommonAncestor(root.right, nodes);
        if (leftAncestor != null && rightAncestor != null) return root;
        return leftAncestor != null ? leftAncestor : rightAncestor;
        
    }
}
