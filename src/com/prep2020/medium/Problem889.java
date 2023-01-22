package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem889 {
	/**
	 * O(N^2)
	 * @param pre
	 * @param post
	 * @return
	 */
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, 0, pre.length);
    }
	
	private TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int postStart, int len) {
        TreeNode root = new TreeNode(pre[preStart]);
        if (len == 1) return root;
        int leftVal = pre[preStart + 1];
        int leftIndexInPost = findIndex(post, postStart, postStart + len - 2, leftVal);
        int leftSubtreeLength = leftIndexInPost - postStart + 1;
        root.left = constructFromPrePost(pre, post, preStart + 1, postStart, leftSubtreeLength);
        if (len <= leftSubtreeLength + 1) return root;
        root.right = constructFromPrePost(pre, post, preStart + leftSubtreeLength + 1, postStart + leftSubtreeLength, len - leftSubtreeLength - 1);
        return root;
	}
	
	private int findIndex(int[] arr, int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == val) return i;
		}
		return -1;
	}
}
