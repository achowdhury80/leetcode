package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob101 {
	/**
	 * O(n) time and O(H) space
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
	
	private boolean isSymmetric(TreeNode t1, TreeNode t2) {
		if (t1 == t2) return true;
		if (t1 == null || t2 == null || t1.val != t2.val) return false;
		return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
	}
}
