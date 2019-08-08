package com.leet.algo;
import java.util.*;
public class Prob965 {
	public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int val = root.val;
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	if (node.val != val) return false;
        	if (node.left != null) q.offer(node.left);
        	if (node.right != null) q.offer(node.right);
        }
        return true;
    }
	
	
}
