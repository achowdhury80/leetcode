package comp.prep2019;

public class Prob104 {
	/**
	 * O(N) and O(H) space
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
