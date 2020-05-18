package comp.prep2019;

public class Prob114 {
	public void flatten(TreeNode root) {
        helper(root);
    }
	
	private TreeNode[] helper(TreeNode root) {
		if (root == null) return new TreeNode[] {null, null};
		TreeNode tail = root;
		TreeNode[] left = helper(root.left);
		root.left = null;
		TreeNode[] right = helper(root.right);
		root.right = null;
		if (left[0] != null) {
			root.right = left[0];
			tail = left[1];
		}
		
		if(right[0] != null) {
			tail.right = right[0];
			tail = right[1];
		}
		return new TreeNode[] {root, tail};
	}
}
