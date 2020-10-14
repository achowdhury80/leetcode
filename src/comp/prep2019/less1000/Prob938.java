package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob938 {
	/**
	 * O(N)
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int result = 0;
        if (root.val >= L && root.val <= R) {
        	result += root.val;
        	return result + rangeSumBST(root.left, L, R) 
        		+ rangeSumBST(root.right, L, R);
        } else if (root.val < L) return rangeSumBST(root.right, L, R);
        else return rangeSumBST(root.left, L, R);
    }
}
