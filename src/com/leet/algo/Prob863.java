package com.leet.algo;
import java.util.*;
public class Prob863 {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        TreeNode node = root;
        Deque<TreeNode> dq = findPath(root, target, K);
        List<Integer> result = new ArrayList<>();
        TreeNode prev = null;
        while(!dq.isEmpty()) {
        	TreeNode next = dq.pollFirst();
        	if (prev == null) result.addAll(distanceK(next, K)); 
        	else if (K == 0) result.add(next.val);
        	else {
        		if (next.right == prev && next.left != null) result.addAll(distanceK(next.left, K - 1));
        		if (next.left == prev && next.right != null) result.addAll(distanceK(next.right, K - 1));
        	}
        	prev = next;
        	K--;
        }
        return result;
    }
	
	private Deque<TreeNode> findPath(TreeNode root, TreeNode target, int k) {
		if (root == null) return null;
		Deque<TreeNode> dq;
		if (root == target) {
			dq = new ArrayDeque<>();
			dq.offerLast(root);
			return dq;
		}
		dq = findPath(root.left, target, k);
		if (dq != null) {
			if (dq.size() < k + 1) dq.offerLast(root);
			return dq;
		} 
		dq = findPath(root.right, target, k);
		if (dq != null) {
			if (dq.size() < k + 1) dq.offerLast(root);
			return dq;
		}
		return null;
	}
	
	private List<Integer> distanceK(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty() && k > 0) {
			k--;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
		}
		if (k > 0) return list;
		while(!q.isEmpty()) {
			list.add(q.poll().val);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Prob863 prob = new Prob863();
		TreeNode two = new TreeNode(2);
		two.left = new TreeNode(7);
		two.right = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		one.left = new TreeNode(0);
		one.right = new TreeNode(8);
		TreeNode five = new TreeNode(5);
		five.left = new TreeNode(6);
		five.right = two;
		TreeNode root = new TreeNode(3);
		root.left = five;
		root.right = one;
		System.out.println(prob.distanceK(root, five, 2));
		
		
		
	}
}
