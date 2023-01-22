package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem938 {
	/**
	 * O(N)
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) return 0;
        int result = 0;
        if (root.val >= low && root.val <= high) {
        	result += root.val;
        	result += rangeSumBST(root.left, low, high);
        	result += rangeSumBST(root.right, low, high);
        }
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else return rangeSumBST(root.right, low, high);
        return result;
    }
}
