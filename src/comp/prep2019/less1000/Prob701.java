package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob701 {
	/**
	 * O(H) or O(Logn) worst case O(N)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
        if (val > root.val) {
        	root.right = insertIntoBST(root.right, val);
        } else {
        	root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
