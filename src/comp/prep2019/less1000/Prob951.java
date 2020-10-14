package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob951 {
	/**
	 * O(min(N1, N2) time and O(min(H1, H2)) space
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        		|| flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
