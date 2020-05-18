package comp.prep2019;

public class Pob538 {
	/**
	 * O(N) time O(H) space
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
		if (root == null) return null;
        helper(root, 0);
        return root;
    }
	
	/**
	 * pre is the parent node val
	 * returns the maximum key
	 * do right traversal first. It will return the max(leftmost) node val
	 * update root val
	 * do left node traversal
	 * @param root
	 * @param pre
	 * @return
	 */
	private int helper(TreeNode root, int pre) {
		int max = 0;
		if (root.right != null) {
			max = helper(root.right, pre);
			root.val += max;
		} else root.val += pre;
		if (root.left == null) return root.val;
		return helper(root.left, root.val);
		
	}
}
