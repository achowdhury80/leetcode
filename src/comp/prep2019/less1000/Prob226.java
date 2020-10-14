package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob226 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
}
