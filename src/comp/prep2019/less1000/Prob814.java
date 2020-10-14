package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob814 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
