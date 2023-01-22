package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem1008 {
	/**
	 * O(N) time and space
	 * @param preorder
	 * @return
	 */
	public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
	
	private TreeNode helper(int[] preorder, int start, int end) {
		TreeNode result = new TreeNode(preorder[start]);
		int leftEndIndex = -1;
		for (int i = start + 1; i <= end; i++) {
			if (preorder[i] < preorder[start]) leftEndIndex = i;
		}
		if (leftEndIndex > -1) result.left = helper(preorder, start + 1, leftEndIndex);
		int rightStartIndex = leftEndIndex > - 1 ? (leftEndIndex + 1) : start + 1;
		if (rightStartIndex <= end) result.right = helper(preorder, rightStartIndex, end);
		return result;
	}
}
