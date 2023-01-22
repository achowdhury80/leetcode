package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem145 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(0, node.val);
			if (node.left != null) stack.push(node.left);
			if(node.right != null) stack.push(node.right);
		}
		
		return result;
    }
}
