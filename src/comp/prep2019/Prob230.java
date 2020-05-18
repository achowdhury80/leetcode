package comp.prep2019;

import java.util.Arrays;

public class Prob230 {
	public int kthSmallest(TreeNode root, int k) {
        return (int)kthSmallestNSize(root, k)[0];
    }
	
	private long[] kthSmallestNSize(TreeNode root, int k) {
        if (root == null) return new long[] {Integer.MIN_VALUE - 1l, 0}; 
        long[] left = kthSmallestNSize(root.left, k);
        if (left[0] >= Integer.MIN_VALUE) return new long[] {left[0], 0};
        k -= left[1];
        if (k == 1) return new long[] {root.val, 0};
        long[] right = kthSmallestNSize(root.right, k - 1);
        if (right[0] >= Integer.MIN_VALUE) return new long[] {right[0], 0};
        return new long[] {-1l + Integer.MIN_VALUE, left[1] + 1 + right[1]}; 
    }
	
	public static void main(String[] args) {
		Prob230 prob = new Prob230();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(prob.kthSmallest(root, 1));
	}
}
