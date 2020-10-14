package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob98 {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1l, Integer.MAX_VALUE + 1l);
    }
	
	private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
