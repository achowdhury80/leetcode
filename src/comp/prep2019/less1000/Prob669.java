package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob669 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        else if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
