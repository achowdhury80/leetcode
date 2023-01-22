package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem106 {
	/**
	 * O(N) time and space
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, postorder, 0, inorder.length - 1, 0, 
				inorder.length - 1);
    }
	
	private TreeNode helper(int[] inorder, int[] postorder, int inStart, 
			int inEnd, int postStart, int postEnd) {
		TreeNode node = new TreeNode(postorder[postEnd]);
		if (postStart == postEnd) return node;
		int inorderRootPos = findPos(inorder, inStart, postorder[postEnd]);
		int postorderLeftEndPos = postStart - 1;
		if (inorderRootPos > inStart) {
			postorderLeftEndPos = postStart + inorderRootPos - inStart - 1;
			node.left = helper(inorder, postorder, inStart, 
					inorderRootPos - 1, postStart, postorderLeftEndPos);
		}
		if (inorderRootPos < inEnd) {
			node.right = helper(inorder, postorder, inorderRootPos + 1, 
					inEnd, postorderLeftEndPos + 1, postEnd - 1);
		}
		return node;
        
    }
	
	private int findPos(int[] arr, int start, int val) {
		for (int i = start; i < arr.length; i++) if (arr[i] == val) return i;
		return -1;
	}
}
