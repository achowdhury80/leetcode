package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem103 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		boolean regular = true;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (regular) list.add(node.val);
				else list.add(0, node.val);
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
			regular = !regular;
			result.add(list);
		}
		return result;
    }
}
