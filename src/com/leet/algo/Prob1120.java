package com.leet.algo;

public class Prob1120 {
	public double maximumAverageSubtree(TreeNode root) {
        double[] arr = maximumAverageAndCountSubtree(root);
        return arr[0] > arr[1] ? arr[0] : arr[1];
    }
	
	private double[] maximumAverageAndCountSubtree(TreeNode root) {
        if (root.left == null && root.right == null) return new double[] {0, root.val, 1.0};
        double[] left = new double[] {0, 0, 0};
        double[] right = new double[] {0, 0, 0};
        if (root.left != null) left = maximumAverageAndCountSubtree(root.left);
        if (root.right != null) right = maximumAverageAndCountSubtree(root.right);
        double maxSubAvg = 0;
        if (left[1] > 0) maxSubAvg = Math.max(left[0], left[1]);
        if (right[1] > 0) maxSubAvg = Math.max(maxSubAvg, Math.max(right[0], right[1]));
        double[] cur = new double[] {maxSubAvg, (root.val + left[1] * left[2] + right[1] * right[2]) / (1 + left[2] + right[2]), 
        		(1 + left[2] + right[2])};
        return cur;
    }
	
	public static void main(String[] args) {
		Prob1120 prob = new Prob1120();
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(1);
		System.out.println(prob.maximumAverageSubtree(root));
	}
}
