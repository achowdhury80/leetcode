package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem865 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
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

	private TreeNode findLca(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null || left == null || right == null) return null;
		if (root == left || root == right) return root;
		TreeNode leftAncestor = findLca(root.left, left, right);
		TreeNode rightAncestor = findLca(root.right, left, right);
		if (leftAncestor != null && rightAncestor != null) return root;
		return leftAncestor == null ? rightAncestor : leftAncestor;
	}
}
