package com.leet.algo;
import java.util.*;
public class Prob865 {
	/**
	 * 
	 * do bfs to find deepest level nodes
	 * find lca of first and last node at the deepest level
	 * if there is one node, return the node itself
	 * @param root
	 * @return
	 */
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
        	Deque<TreeNode> nextLevel = new ArrayDeque<>();
        	for (TreeNode node : dq) {
	        	if (node.left != null) nextLevel.offer(node.left);
	        	if (node.right != null) nextLevel.offer(node.right);
        	}
        	if (nextLevel.isEmpty()) {
        		return dq.size() == 1 ? dq.poll() : lca(root, dq.getFirst(), dq.getLast());
        	} else dq = nextLevel;
        }
        return null;
    }
	
	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root) return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		return left == null ? right : (right == null ? left : root);
	}
}
