package com.prep2020.easy;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem1469 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		findLonelyNodes(root.left, root, result);
		findLonelyNodes(root.right, root, result);
		return result;
    }
	
	private void findLonelyNodes(TreeNode node, TreeNode parent, List<Integer> result) {
		if (node == null) return;
		if (parent.left == null || parent.right == null) result.add(node.val);
		findLonelyNodes(node.left, node, result);
		findLonelyNodes(node.right, node, result);
	}
}
