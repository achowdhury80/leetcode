package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem663 {
	public boolean checkEqualTree(TreeNode root) {
		findSum(root);
		return partitionExists(root, 0);
    }
	
	private boolean partitionExists(TreeNode root, int parentVal) {
		if (root == null) return false;
		int left = root.left != null ? root.left.val : 0;
		int right = root.right != null ? root.right.val : 0;
		int rootVal = root.val - left - right;
		if (root.right != null && rootVal + parentVal + left == right) return true;
		if (root.left != null && rootVal + parentVal + right == left) return true;
		if (root.left != null && partitionExists(root.left, parentVal 
				+ rootVal + right)) return true;
		if (root.right != null && partitionExists(root.right, parentVal 
				+ rootVal + left)) return true;
		return false;
	}

	private int findSum(TreeNode root) {
		if (root == null) return 0;
		int leftSum = findSum(root.left);
		int rightSum = findSum(root.right);
		root.val += (leftSum + rightSum);
		return root.val;
	}
	
	public static void main(String[] args) {
		Problem663 problem = new Problem663();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(3);
		System.out.println(problem.checkEqualTree(root));
	}
}
