package com.leet.algo;
import java.util.*;
public class Prob272 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
        Queue<TreeNode> q = new PriorityQueue<>((x, y) -> Double.compare(Math.abs(y.val - target), Math.abs(x.val - target)));
        dfs(root, q, k);
        while(!q.isEmpty()) result.add(q.poll().val);
        return result;
	}
	
	private void dfs(TreeNode root, Queue<TreeNode> q, int k) {
		if (root == null) return;
		q.offer(root);
		if (q.size() > k) q.poll();
		dfs(root.left, q, k);
		dfs(root.right, q, k);
	}
}
