package com.leet.algo;
public class Prob979 {
	public int distributeCoins(TreeNode root) {
        return helper(root)[0];
    }
	
	// number of moves, out (+) or in (-)
	public int[] helper(TreeNode root) {
		int[] left = new int[2], right = new int[2];
        if (root.left != null) {
        	left = helper(root.left);
        }
        if (root.right != null) {
        	right = helper(root.right);
        }
        int coins = left[1] + right[1];
    	int move = left[0] + right[0];
    	return new int[] {move + Math.abs(coins + root.val - 1), root.val + coins - 1};
    }
}
