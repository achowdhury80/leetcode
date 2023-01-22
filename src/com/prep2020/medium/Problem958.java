package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem958 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean nullFound = false;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (cur.left == null) nullFound = true;
        		else {
        			if (nullFound) return false;
        			q.offer(cur.left);
        		}
        		if (cur.right == null) nullFound = true;
        		else {
        			if (nullFound) return false;
        			q.offer(cur.right);
        		}
        	}
        }
        return true;
    }
}
