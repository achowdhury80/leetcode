package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem742 {
	public int findClosestLeaf(TreeNode root, int k) {
        boolean[] visited = new boolean[1001];
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = findNode(root, k, stack);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        visited[k] = true;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (cur.left == null && cur.right == null) return cur.val;
        		if (cur.left != null && !visited[cur.left.val]) {
        			q.offer(cur.left);
        			visited[cur.left.val] = true;
        		}
        		if (cur.right != null && !visited[cur.right.val]) {
        			q.offer(cur.right);
        			visited[cur.right.val] = true;
        		}
        		if (!stack.isEmpty()) {
        			TreeNode n = stack.pop();
        			q.offer(n);
        			visited[n.val] = true;
        		}
        	}
        }
        return -1;
    }
	
	private TreeNode findNode(TreeNode root, int k, Deque<TreeNode> stack) {
		if (root.val == k) return root;
		stack.push(root);
		if (root.left != null) {
			TreeNode left = findNode(root.left, k, stack);
			if (left != null) return left;
		}
		if (root.right != null) {
			TreeNode right = findNode(root.right, k, stack);
			if (right != null) return right;
		}
		stack.pop();
		return null;
	}
}
