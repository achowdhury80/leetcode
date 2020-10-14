package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

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
