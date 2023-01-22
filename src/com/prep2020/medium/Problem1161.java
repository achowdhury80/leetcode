package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem1161 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int maxLevelSum(TreeNode root) {
		int[] arr = new int[] {Integer.MIN_VALUE, 0};
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;
		while(!q.isEmpty()) {
			int sum = 0, size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
				sum += node.val;
			}
			if (arr[0] < sum) {
				arr = new int[] {sum, level};
			}
			level++;
		}
		return arr[1];
    }
}
