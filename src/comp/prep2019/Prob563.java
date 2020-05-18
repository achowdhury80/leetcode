package comp.prep2019;

public class Prob563 {
	/**
	 * O(N) time as it goes through all node
	 * O(H) space - the recursion stack size , the height of the tree
	 * @param root
	 * @return
	 */
	public int findTilt(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	/**
	 * returns the sum of all nodes the the tree
	 * also add the tilt of the root node to result
	 * @param root
	 * @param result
	 * @return
	 */
	private int helper(TreeNode root, int[] result) {
		if (root == null) return 0;
		int leftSum = helper(root.left, result);
		int rightSum = helper(root.right, result);
		result[0] += Math.abs(leftSum - rightSum);
		return leftSum + root.val + rightSum;
	}
}
