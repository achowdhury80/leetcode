package comp.prep2019;

public class Prob897 {
	/**
	 * O(N) - traversing each node and O(H) space - recursion will heigh space deep
	 * Special care - need to set root.left  null
	 * @param root
	 * @return
	 */
	public TreeNode increasingBST(TreeNode root) {
        return helper(root)[0];
    }
	
	private TreeNode[] helper(TreeNode root) {
		if (root == null) return new TreeNode[] {null, null};
		TreeNode[] arr = helper(root.right);
		root.right = null;
		if (root.left == null) {
			root.right = arr[0];
			return new TreeNode[] {root, arr[1] == null ? root : arr[1]};
		} else {
			TreeNode[] left = helper(root.left);
			root.left = null;
			left[1].right = root;
			root.right = arr[0];
			return new TreeNode[] {left[0], arr[1] == null ? root : arr[1]};
		}
	}
	 
}
