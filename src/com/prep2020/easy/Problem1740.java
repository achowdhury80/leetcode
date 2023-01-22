package com.prep2020.easy;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1740 {
	public int findDistance(TreeNode root, int p, int q) {
        TreeNode start = findNode(root, p, q);
        int target = q;
        if (start.val == q) target = p;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        int result = 0;
        return 0;
    }
	
	/**
	 * finds the node having value either p or q
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	private TreeNode findNode(TreeNode root, int p, int q) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val == p || node.val == q) return node;
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
		}
		return null;
		
	}
	
	private TreeNode findCommonAncestor(TreeNode root, int p, int q) {
		if (root.val == p && find(root, q)) return root;
		if (root.val == q && find(root, p)) return root;
		find(root, q);
		return null;
	}

	private boolean find(TreeNode root, int q) {
		// TODO Auto-generated method stub
		return false;
	}
}
