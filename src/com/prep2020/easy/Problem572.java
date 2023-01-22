package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem572 {
	/**
	 * O(M * N)
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			if (t == null) return true;
			return false;
		}
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == t) return true;
		if (s == null || t == null || s.val != t.val) return false;
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
}
