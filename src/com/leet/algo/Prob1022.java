package com.leet.algo;
public class Prob1022 {
	public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int[] sum = new int[1];
        inorder(root, 0, sum);
        return sum[0];
    }
	
	private void inorder(TreeNode root, int val, int[] sum) {
		if (root.left == null && root.right == null) {
			sum[0] += val * 2 + root.val;
			return;
		}
		if (root.left != null) {
			inorder(root.left, val * 2 + root.val, sum);
		}
		if (root.right != null) {
			inorder(root.right, val * 2 + root.val, sum);
		}
	}
}
