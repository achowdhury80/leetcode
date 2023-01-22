package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1123 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        // find deepest level end leaves
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		List<TreeNode> prev = null;
		while(!q.isEmpty()) {
			int size = q.size();
			prev = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i == 0 || i == size - 1) prev.add(node);
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
		}
		if (prev.size() == 1) return prev.get(0);
		return findLca(root, prev.get(0), prev.get(1));
    }

	private TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return null;
		if (root == p || root == q) return root;
		TreeNode left = findLca(root.left, p, q);
		TreeNode right = findLca(root.right, p, q);
		if (left != null && right != null) return root;
		return left == null ? right : left;
	}
}
