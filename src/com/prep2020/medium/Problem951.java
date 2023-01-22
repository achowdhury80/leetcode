package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem951 {
	/**
	 * O(N1 + N2)
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) 
        		|| flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
    }
}
