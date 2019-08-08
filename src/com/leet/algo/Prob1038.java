package com.leet.algo;

public class Prob1038 {
	public TreeNode bstToGst(TreeNode root) {
		return bstToGst(root, 0);
    }
	
	// will have parent val if left child otherwise 0
	private TreeNode bstToGst(TreeNode root, int parentVal) {
		if (root == null) return root;
		if (root.right != null) {
			root.right = bstToGst(root.right, parentVal);
			TreeNode child = root.right;
			while(child.left != null) child = child.left;
			root.val += child.val;
		} else root.val += parentVal;
		root.left = bstToGst(root.left, root.val);
        return root;
    }
}
