package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem230 {
	/**
	 * O(N) time and space
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        stack.push(node);
        while(node.left != null) {
        	node = node.left;
        	stack.push(node);
        }
        int i = 0;
        while(!stack.isEmpty()) {
        	node = stack.pop();
        	i++;
        	if (i == k) return node.val;
        	if (node.right != null) {
        		node = node.right;
        		stack.push(node);
        		while(node.left != null) {
                	node = node.left;
                	stack.push(node);
                }
        	}
        }
        return -1;
    }
}
