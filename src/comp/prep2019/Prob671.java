package comp.prep2019;

public class Prob671 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }
	/*
	 * check if root val != val
	 * otherwise find the min of left and right subtree
	 * 
	 */
	private int helper(TreeNode root, int val) {
		if (root == null) return -1;
		if (root.val != val) return root.val;
		int left = helper(root.left, val);
		int right = helper(root.right, val);
		if (left == -1) return right;
		else if (right == -1) return left;
		return Math.min(left,  right);
	}
}
