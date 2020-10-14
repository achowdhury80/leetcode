package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob250 {
	public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[1];
        isUniValueSubtree(root, result);
        return result[0];
    }
	
	private boolean isUniValueSubtree(TreeNode root, int[] result) {
		if (root == null) return true;
		boolean isLeftUni = isUniValueSubtree(root.left, result);
		boolean isRightUni = isUniValueSubtree(root.right, result);
		if (!isLeftUni || !isRightUni) return false;
		if ((root.left == null || root.val == root.left.val) 
				&& (root.right == null || root.val == root.right.val)) {
			result[0]++;
			return true;
		}
		return false;
	}
}
