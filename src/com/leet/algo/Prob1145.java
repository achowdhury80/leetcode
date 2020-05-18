package com.leet.algo;

public class Prob1145 {
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode first = findNode(root, x);
        int leftCount = findNodeCount(first.left);
        int rightCount = findNodeCount(first.right);
        int firstCount = 1 + leftCount + rightCount;
        return n > 2 * firstCount || 2 * leftCount > n || 2 * rightCount > n;
        
    }
	
	private int findNodeCount(TreeNode root) {
		if (root == null) return 0;
		return 1 + findNodeCount(root.left) + findNodeCount(root.right);
	}
	
	private TreeNode findNode(TreeNode root, int val) {
		if (root == null) return null;
		if (root.val == val) return root;
		TreeNode left = findNode(root.left, val);
		if (left != null) return left;
		return findNode(root.right, val);
	}
}
