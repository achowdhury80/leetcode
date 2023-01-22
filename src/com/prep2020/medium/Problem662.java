package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem662 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {
	    int result = 0;
	    Map<TreeNode, Integer> map = new HashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(root);
	    map.put(root, 0);
	    while(!q.isEmpty()) {
	    	int size = q.size(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	    	for (int i = 0; i < size; i++) {
	    		TreeNode cur = q.poll();
	    		int curIndex = map.get(cur);
	    		min = Math.min(min, curIndex);
	    		max = Math.max(max, curIndex);
	    		if (cur.left != null) {
	    			q.offer(cur.left);
	    			map.put(cur.left, 2 * curIndex + 1);
	    		}
	    		if (cur.right != null) {
	    			q.offer(cur.right);
	    			map.put(cur.right, 2 * curIndex + 2);
	    		}
	    	}
	    	result = Math.max(result, max - min + 1);
	    }
	    return result;
	}
}
