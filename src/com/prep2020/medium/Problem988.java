package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem988 {
	public String smallestFromLeaf(TreeNode root) {
        String[] result = new String[] {""};
        helper(root, "", result);
        return result[0];
    }

	private void helper(TreeNode root, String cur, String[] result) {
		cur = "" + (char)(root.val + 'a') + cur;
		if (root.left == null && root.right == null) {
			if (result[0].equals("") || result[0].compareTo(cur) > 0) result[0] = cur;
			return;
		}
		if (root.left != null) helper(root.left, cur, result);
		if (root.right != null) helper(root.right, cur, result);
	}
}
