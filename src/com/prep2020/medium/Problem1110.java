package com.prep2020.medium;

import java.util.*;

import com.prep2020.TreeNode;

public class Problem1110 {
	/**
	 * O(N)
	 * @param root
	 * @param to_delete
	 * @return
	 */
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<>();
		for (int i : to_delete) set.add(i);
		List<TreeNode> result = new ArrayList<>();
		helper(root, null, set, result);
		return result;
    }
	
	public void helper(TreeNode node, TreeNode parent, Set<Integer> set, List<TreeNode> result) {
		TreeNode nextParent = node;
		if (!set.contains(node.val)) {
            if (parent == null) result.add(node);
		} else {
			if (parent != null && parent.left == node) parent.left = null;
			else if (parent != null && parent.right == node) parent.right = null;
			nextParent = null;
		}
		if (node.left != null) helper(node.left, nextParent, set, result);
		if (node.right != null) helper(node.right, nextParent, set, result);
	}
}
