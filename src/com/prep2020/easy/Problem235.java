package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem235 {
	/**
	 * o(N)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int mult = (root.val - p.val) * (root.val - q.val);
        if (mult <= 0) return root;
        if (root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
