package comp.prep2019;

public class Prob965 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }
	
	private boolean helper(TreeNode root, int val) {
		if (root == null) return true;
		if (root.val != val) return false;
		return helper(root.left, val) && helper(root.right, val);
	}
}
