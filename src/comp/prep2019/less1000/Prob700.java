package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob700 {
	/**
	 * O(logN)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
