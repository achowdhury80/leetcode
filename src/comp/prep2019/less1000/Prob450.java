package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
        if (root.val == key) {
        	if (root.right == null) return root.left;
        	if (root.left == null) return root.right;
        	TreeNode node = findLeftMost(root.right);
        	node.left = root.left;
        	return root.right;
        } else if (root.val > key) {
        	root.left = deleteNode(root.left, key);
        } else {
        	root.right = deleteNode(root.right, key);
        }
        return root;
    }
	
	private TreeNode findLeftMost(TreeNode root) {
		while(root.left != null) root = root.left;
		return root;
	}
}
