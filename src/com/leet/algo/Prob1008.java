package com.leet.algo;

public class Prob1008 {
	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
	
	public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= preorder.length) return null;
        if (start == end) return new TreeNode(preorder[start]);
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        int i = start;
        while (i < end && preorder[i + 1] < val) {
        	i++;
        }
        if (i > start) root.left = bstFromPreorder(preorder, start + 1, i);
        if (i < end) root.right = bstFromPreorder(preorder, i + 1, end);
        return root;
    }
}
