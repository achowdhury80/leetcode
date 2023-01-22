package com.prep2020.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.prep2020.TreeNode;

public class Problem919 {
	private TreeNode root;
	private Queue<TreeNode> cur, next;
	public Problem919(TreeNode root) {
        this.root = root;
        cur = new LinkedList<>();
        next = new LinkedList<>();
        cur.offer(root);
        while(!cur.isEmpty()) {
        	int size = cur.size();
        	for (int i = 0; i < size; i++) {
        		if (cur.peek().left == null) {
            		break;
            	}
            	next.offer(cur.peek().left);
            	if(cur.peek().right == null) {
            		break;
            	}
            	next.offer(cur.poll().right);
        	}
        	if (cur.isEmpty()) {
        		cur = next;
        		next = new LinkedList<>();
        	} else break;
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode peek = cur.peek();
        if (peek.left == null) {
        	peek.left = node;
        	next.offer(node);
        	return peek.val;
        } else {
        	peek.right = node;
        	next.offer(node);
        	cur.poll();
        	if(cur.isEmpty()) {
        		cur = next;
        		next = new LinkedList<>();
        	}
        	return peek.val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
}
