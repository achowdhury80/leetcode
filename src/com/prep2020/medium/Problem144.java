package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem144 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		
		return result;
    }
}
