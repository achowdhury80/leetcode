package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem2236 {
	public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
