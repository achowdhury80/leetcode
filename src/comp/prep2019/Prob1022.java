package comp.prep2019;
public class Prob1022 {
	/**
	 * O(N) time and O(H) space -- recursion stack
	 * call a helper method with previous parent value
	 * if any of the child node is not null, go for the helper call with 
	 * updating parent value
	 * @param root
	 * @return
	 */
	public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
	
	private int helper(TreeNode root, int prev) {
		int cur = ((prev << 1) | root.val);
		if (root.left == null && root.right == null) return cur;
		int result = 0;
		if (root.left != null) {
			result += helper(root.left, cur);
		}
		if (root.right != null) {
			result += helper(root.right, cur);
		}
		return result;
	}
}
