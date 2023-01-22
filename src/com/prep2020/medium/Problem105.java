package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem105 {
	/**
	 * O(N) space and time complexity
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, 
        		preorder.length - 1);
    }
	
	private TreeNode helper(int[] preorder, int[] inorder, int preStart, 
			int preEnd, int inStart, int inEnd) {
		TreeNode node = new TreeNode(preorder[preStart]);
		if (preStart == preEnd) return node;
		int inorderRootPos = findPos(inorder, inStart, preorder[preStart]);
		int preorderLeftEndPos = preStart;
		if (inorderRootPos > inStart) {
			preorderLeftEndPos = preStart + inorderRootPos - inStart;
			node.left = helper(preorder, inorder, preStart + 1, 
					preorderLeftEndPos, inStart, inorderRootPos - 1);
		}
		if (inorderRootPos < inEnd) {
			node.right = helper(preorder, inorder, preorderLeftEndPos + 1, 
					preEnd, inorderRootPos + 1, inEnd);
		}
		return node;
        
    }
	
	private int findPos(int[] arr, int start, int val) {
		for (int i = start; i < arr.length; i++) if (arr[i] == val) return i;
		return -1;
	}
	
	public static void main(String[] args) {
		Problem105 problem = new Problem105();
		TreeNode root = problem.buildTree(new int[] {1, 2, 3}, 
				new int[] {3, 2, 1});
		System.out.println(root);
	}
}
