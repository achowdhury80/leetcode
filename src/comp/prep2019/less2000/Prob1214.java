package comp.prep2019.less2000;

import comp.prep2019.TreeNode;

public class Prob1214 {
	/**
	 * O(MlogN)
	 * @param root1
	 * @param root2
	 * @param target
	 * @return
	 */
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		if (found(root2, target - root1.val)) return true;
        if (root1.left != null && twoSumBSTs(root1.left, root2, target)) return true;
        if (root1.right != null && twoSumBSTs(root1.right, root2, target)) return true;
        return false;
    }
	
	private boolean found(TreeNode root, int target) {
		if (root == null) return false;
		if (root.val == target) return true;
		return root.val > target ? found(root.left, target) : found(root.right, target);
	}
}
