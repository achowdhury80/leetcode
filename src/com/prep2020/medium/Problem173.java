package com.prep2020.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.prep2020.TreeNode;

public class Problem173 {
	Deque<TreeNode> stack;
	public Problem173(TreeNode root) {
        stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        int result = cur.val;
        cur = cur.right;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        return result;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
