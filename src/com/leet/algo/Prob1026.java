package com.leet.algo;

public class Prob1026 {
	public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffWithMaxMin(root)[0];
    }
	
	// arr[0] maxAncesDiff
	// arr[1] max
	//arr[2] min
	private int[] maxAncestorDiffWithMaxMin(TreeNode root) {
		int[] result = new int[] {-1, -1, -1};
		if (root.left == null && root.right == null) {
			result[1] = root.val;
			result[2] = root.val;
			return result;
		}
		if (root.left != null) {
			result = maxAncestorDiffWithMaxMin(root.left);
		}
		if (root.right != null) {
			int[] temp = maxAncestorDiffWithMaxMin(root.right);
			if (result[0] == -1 || result[0] < temp[0]) {
				result[0] = temp[0];
			}
			result[1] = Math.max(result[1], temp[1]);
			if (result[2] == -1 || result[2] > temp[2]) {
				result[2] = temp[2];
			}
		}
		result[0] = Math.max(result[0], Math.max(Math.abs(result[1] - root.val), 
				Math.abs(root.val - result[2])));
		result[1] = Math.max(result[1], root.val);
		if (result[2] == -1 || root.val < result[2]) result[2] = root.val;
		return result;
    }
}
