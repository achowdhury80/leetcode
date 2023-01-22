package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1609 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public boolean isEvenOddTree(TreeNode root) {
		List<TreeNode> cur = new ArrayList<>();
		cur.add(root);
		boolean isEven = false;
		while(true) {
			List<TreeNode> next = new ArrayList<>();
			if (!isValid(cur, isEven, next)) return false;
			if (next.isEmpty()) return true;
			isEven = !isEven;
			cur = next;
		}
    }
	
	private boolean isValid(List<TreeNode> cur, boolean isEven, 
			List<TreeNode> next) {
		if (cur.isEmpty()) return true;
		boolean decreasing = isEven;
		int prev = 0;
		for(TreeNode node : cur) {
			if (isEven && node.val % 2 == 1) return false;
			if (!isEven && node.val % 2 == 0) return false;
			if (prev != 0) {
				if (decreasing && prev <= node.val) return false;
				if (!decreasing && prev >= node.val) return false;
			}
			prev = node.val;
			if (node.left != null) next.add(node.left);
			if (node.right != null) next.add(node.right);
		}
		return true;
	}
}
