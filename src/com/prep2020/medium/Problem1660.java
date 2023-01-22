package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1660 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[] {root, null});
        TreeNode[] childParent = null;
        while(!q.isEmpty()) {
        	int size = q.size();
        	Set<TreeNode> set = new HashSet<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode[] nodes = q.poll();
        		if (nodes[0].right != null && set.contains(nodes[0].right)) {
        			childParent = nodes;
        			break;
        		}
        		set.add(nodes[0]);
        		if (nodes[0].right != null) q.offer(new TreeNode[] {nodes[0].right, nodes[0]});
        		if (nodes[0].left != null) q.offer(new TreeNode[] {nodes[0].left, nodes[0]});
        	}
        	if (childParent != null) break;
        	
        }
        if (childParent[1].left == childParent[0]) {
    		childParent[1].left = null;
    	} else {
    		childParent[1].right = null;
    	}
        return root;
    }
}
