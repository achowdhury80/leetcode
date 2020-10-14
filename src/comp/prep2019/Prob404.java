package comp.prep2019;

public class Prob404 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		int[] result = new int[1];
        helper(root, false, result);
        return result[0];
    }
	
	private void helper(TreeNode root, boolean isLeft, int[] result) {
		if (root == null) return;
		if (isLeft && root.left == null && root.right == null) {
			result[0] += root.val;
			return;
		}
		helper(root.left, true, result);
		helper(root.right, false, result);
	}
}
