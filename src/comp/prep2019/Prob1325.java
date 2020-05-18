package comp.prep2019;

public class Prob1325 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param target
	 * @return
	 */
	public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if (left == null && right == null && root.val == target) return null;
        root.left = left;
        root.right = right;
        return root;
    }
}
