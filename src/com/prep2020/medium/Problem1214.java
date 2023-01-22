package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1214 {
	/**
	 * let m and n be number of nodes for tree 1 and 2 respectively
	 * O(MlogH) where H is the height of 2nd tree
	 * @param root1
	 * @param root2
	 * @param target
	 * @return
	 */
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		if (root1 == null) return false;
        if (search(root2, target - root1.val)) return true;
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }
	
	private boolean search(TreeNode root, int val) {
		if (root == null) return false;
		if (root.val == val) return true;
		return root.val > val ? search(root.left, val) : search(root.right, val);
	}
}
