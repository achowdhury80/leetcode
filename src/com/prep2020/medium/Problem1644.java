package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1644 {
	/**
	 * O(N)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1 = new ArrayDeque<>(), 
        		stack2 = new ArrayDeque<>();
        if (!FindPath(root, p, stack1)) return null;
        if (!FindPath(root, q, stack2)) return null;
        while(stack1.size() > stack2.size()) stack1.pop();
        while(stack2.size() > stack1.size()) stack2.pop();
        while(!stack1.isEmpty()) {
        	if (stack1.peek() == stack2.peek()) return stack1.peek();
        	stack1.pop();
        	stack2.pop();
        }
        return null;
    }

	private boolean FindPath(TreeNode root, TreeNode p, Deque<TreeNode> stack) {
		stack.push(root);
		if (root == p) return true;
		if (root.left != null && FindPath(root.left, p, stack)) return true;
		if (root.right != null && FindPath(root.right, p, stack)) return true;
		stack.pop();
		return false;
	}
}
