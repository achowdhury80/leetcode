package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1302 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<TreeNode> list = new ArrayList<>();
        while(!q.isEmpty()) {
        	list.clear();
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		list.add(node);
        		if (node.left != null) q.offer(node.left);
        		if (node.right != null) q.offer(node.right);
        	}
        }
        int sum = 0;
        for (TreeNode node : list) sum += node.val;
        return sum;
    }
}
