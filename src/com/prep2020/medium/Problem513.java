package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem513 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int result = -1;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result = q.peek().val;
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left != null) q.offer(node.left);
        		if(node.right != null) q.offer(node.right);
        	}
        }
        return result;
    }
}
