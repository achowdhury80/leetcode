package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
				if (i == size - 1) result.add(node.val);
			}
		}
		return result;
    }
}
