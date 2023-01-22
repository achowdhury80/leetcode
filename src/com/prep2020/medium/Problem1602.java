package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1602 {
	/**
	 * O(N)
	 * @param root
	 * @param u
	 * @return
	 */
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (cur == u) {
        			if (i == size - 1) return null;
        			return q.poll();
        		}
        		if (cur.left != null) q.offer(cur.left);
        		if(cur.right != null) q.offer(cur.right);
        	}
        }
        return null;
    }
}
