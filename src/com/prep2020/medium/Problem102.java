package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem102 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			result.add(list);
		}
		return result;
    }
}
