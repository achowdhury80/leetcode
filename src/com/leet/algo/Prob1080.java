package com.leet.algo;

public class Prob1080 {
	 public TreeNode sufficientSubset(TreeNode root, int limit) {
	        return sufficientSubset(root, limit, 0);
	    }
		
		private TreeNode sufficientSubset(TreeNode root, int limit, int sum) {
	        if (root == null) return null;
	        if (root.left == null && root.right == null) {
	        	if (sum + root.val < limit) return null;
	        	else return root;
	        }
	        TreeNode left = sufficientSubset(root.left, limit, sum + root.val);
	        TreeNode right = sufficientSubset(root.right, limit, sum + root.val);
	        root.left = left;
	        root.right = right;
	        if (root.left == null && root.right == null) {
	        	return null;
	        }
	        return root;
	        
	    }
}
