package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem863 {
	/**
	 * O(N) time space
	 * @param root
	 * @param target
	 * @param K
	 * @return
	 */
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		findTarget(root, target, stack);
		List<Integer> result = new ArrayList<>();
		Set<TreeNode> visited = new HashSet<>();
		while (!stack.isEmpty() && K > -1) {
			TreeNode cur = stack.pop();
			findNodeAtDistanceK(cur, visited, K, result);
			K--;
		}
		return result;
    }
	
	private void findNodeAtDistanceK(TreeNode cur, Set<TreeNode> visited, int k, List<Integer> result) {
		if (visited.contains(cur)) return;
		visited.add(cur);
		if (k == 0) {
			result.add(cur.val);
			return;
		}
		if (cur.left != null) findNodeAtDistanceK(cur.left, visited, k - 1, result);
		if (cur.right != null) findNodeAtDistanceK(cur.right, visited, k - 1, result);
		
	}

	private boolean findTarget(TreeNode root, TreeNode target, Deque<TreeNode> stack) {
		if (root == target) return true;
		if (root.left != null) {
			stack.push(root.left);
			if (findTarget(root.left, target, stack)) return true;
			stack.pop();
		}
		if (root.right != null) {
			stack.push(root.right);
			if (findTarget(root.right, target, stack)) return true;
			stack.pop();
		}
		return false;
	}
	
	
}
