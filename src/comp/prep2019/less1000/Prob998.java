package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob998 {
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode cloned = clone(root);
        return addToMaximumTree(cloned, new TreeNode(val));
    }
	
	private TreeNode clone(TreeNode root) {
		if (root == null) return null;
		TreeNode result = new TreeNode(root.val);
		result.left = clone(root.left);
		result.right = clone(root.right);
		return result;
	}
	
	private TreeNode addToMaximumTree(TreeNode root, TreeNode newNode) {
		if (root == null) return newNode;
		if (root.val < newNode.val) {
			newNode.left = root;
			return newNode;
		}
		root.right = addToMaximumTree(root.right, newNode);
		return root;
		
	}
}
