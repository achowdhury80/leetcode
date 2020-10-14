package comp.prep2019.less2000;

import comp.prep2019.TreeNode;

public class Prob1315 {
	/**
	 * O(N) and O(H)
	 * @param root
	 * @return
	 */
	public int sumEvenGrandparent(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
	
	private int helper(TreeNode root, int parent, int gp) {
		int result = 0;
		if (gp != Integer.MIN_VALUE && gp % 2 == 0) {
			result += root.val;
		}
		if (root.left != null) result += helper(root.left, root.val, parent);
		if (root.right != null) result += helper(root.right, root.val, parent);
		return result;
	}
}
