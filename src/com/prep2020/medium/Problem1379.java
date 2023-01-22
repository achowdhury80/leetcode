package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1379 {
	/**
	 * O(N)
	 * @param original
	 * @param cloned
	 * @param target
	 * @return
	 */
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, 
			final TreeNode target) {
		Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
		q1.offer(original);
		q2.offer(cloned);
		while(!q1.isEmpty()) {
			TreeNode node1 = q1.poll(), node2 = q2.poll();
			if (node1 == target) return node2;
			if (node1.left != null) {
				q1.offer(node1.left);
				q2.offer(node2.left);
			}
			if (node1.right != null) {
				q1.offer(node1.right);
				q2.offer(node2.right);
			}
		}
		return null;
        
    }
}
