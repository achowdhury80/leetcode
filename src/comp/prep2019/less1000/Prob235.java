package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob235 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
        int temp = (p.val - root.val) * (q.val - root.val);
        if (temp <= 0) return root;
        return p.val > root.val ?  lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }
}
