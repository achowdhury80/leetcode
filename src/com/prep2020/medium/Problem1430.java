package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1430 {
	public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }
	
	private boolean helper(TreeNode root, int[] arr, int start) {
		if (start == arr.length) return false;
		if (root.val != arr[start]) return false;
		if (root.left == null && root.right == null) 
			return start == arr.length - 1;
		if (root.left != null && helper(root.left, arr, start + 1)) 
			return true;
		if (root.right != null && helper(root.right, arr, start + 1)) 
			return true;
		return false;
	}
}
