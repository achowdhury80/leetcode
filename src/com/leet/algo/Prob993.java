package com.leet.algo;
import java.util.*;
public class Prob993 {
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root.val == x || root.val == y) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int[] parent = new int[101];
        parent[root.val] = -1;
        while(!q.isEmpty()) {
        	int size = q.size();
        	boolean[] flags = new boolean[2];
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.val == x) {
        			flags[0] = true;
        		} else if (node.val == y) {
        			flags[1] = true;
        		} 
        		if (node.left != null) {
        			q.offer(node.left);
        			parent[node.left.val] = node.val;
        		}
        		if (node.right != null) {
        			q.offer(node.right);
        			parent[node.right.val] = node.val;
        		}
        	}
        	if (flags[0] | flags[1]) {
        		if(flags[0] && flags[1]) {
        			if (parent[x] != parent[y]) return true;
        		}
        		return false;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		Prob993 prob = new Prob993();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		two.right = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		three.right = new TreeNode(5);
		root.left = two;
		root.right = three;
		System.out.println(prob.isCousins(root, 5, 4));
	}
}
