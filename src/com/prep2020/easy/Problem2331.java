package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem2331 {
	public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val == 1;
        boolean left = evaluateTree(root.left), right = evaluateTree(root.right);
        if (root.val == 2) return left | right;
        return left & right;
    }
}
