package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob687 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int longestUnivaluePath(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * 0th element is the longestUniValuePath(with or without root) and 1st element 
	 * is longest path length
	 * including root on one side(either left or right) 
	 * find one sided longest path and th
	 * @param root
	 * @return
	 */
	private int[] helper(TreeNode root) {
		if (root == null) return new int[] {0, 0};
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int longestPathWithRootVal = 0, longestOneSided = 0;
		if (root.left != null && root.left.val == root.val) {
			longestOneSided = 1 + left[1];
			longestPathWithRootVal = 1 + left[1];
		}
		if (root.right != null && root.right.val == root.val) {
			longestOneSided = Math.max(longestOneSided, 1 + right[1]);
			longestPathWithRootVal += 1 + right[1];
		}
		int longestPath = Math.max(longestPathWithRootVal, 
				Math.max(left[0], right[0]));
		return new int[] {longestPath, longestOneSided};
	}
}
