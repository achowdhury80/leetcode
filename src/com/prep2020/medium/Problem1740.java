package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1740 {
	/**
	 * O(N)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public int findDistance(TreeNode root, int p, int q) {
		if (p == q) return 0;
        TreeNode ancestor = findLca(root, p, q);
        int[] dis = new int[] {-1, -1};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(ancestor);
        int level = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if (node.val == p) dis[0] = level;
        		else if (node.val == q) dis[1] = level;
        		if (dis[0] != -1 && dis[1] != -1) return dis[0] + dis[1];
        		if (node.left != null) queue.offer(node.left);
        		if (node.right != null) queue.offer(node.right);
        	}
        	level++;
        }
        return -1;
    }
	
	private TreeNode findLca(TreeNode root, int p, int q) {
		if (root == null) return null;
		if (root.val == p || root.val == q) return root;
		TreeNode left = findLca(root.left, p, q);
		TreeNode right = findLca(root.right, p, q);
		if (left != null && right != null) return root;
		return left == null ? right : left;
	}
}
