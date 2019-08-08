package com.leet.algo;
import java.util.*;
public class Prob958 {
	public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean nullStarted = false;
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	if (nullStarted && node != null) return false;
        	else if (!nullStarted && node == null) {
        		nullStarted = true;
        	} else if (!nullStarted && node != null) {
        		q.offer(node.left);
        		q.offer(node.right);
        	}
        }
        return true;
    }
}
