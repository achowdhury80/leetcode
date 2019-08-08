package com.leet.algo;
import java.util.*;
public class Prob919 {
	private Queue<TreeNode> q;
	private TreeNode root;
	public Prob919(TreeNode root) {
        q = new LinkedList<>();
        this.root = new TreeNode(root.val);
        q.offer(this.root);
        Queue<TreeNode> localQ = new LinkedList<>();
        if (root.left != null) localQ.offer(root.left);
        if (root.right != null) localQ.offer(root.right);
        while (!localQ.isEmpty()) {
        	TreeNode node = localQ.poll();
        	TreeNode newNode = new TreeNode(node.val);
        	if (q.peek().left == null) q.peek().left = newNode;
        	else q.poll().right = newNode;
        	q.offer(newNode);
        	if (node.left != null) localQ.offer(node.left);
        	if (node.right != null) localQ.offer(node.right);
        }
    }
    
    public int insert(int v) {
    	TreeNode newNode = new TreeNode(v);
    	int result = -1;
    	if (q.peek().left == null) {
    		q.peek().left = newNode;
    		result = q.peek().val;
    	}
    	else {
    		TreeNode node = q.poll();
    		node.right = newNode;
    		result = node.val;
    	}
    	q.offer(newNode);
    	return result;
    }
    
    public TreeNode get_root() {
        return root;
    }
    
    public static void main(String[] args) {
    	
    	Prob919 prob = new Prob919(new TreeNode(1));
    	System.out.println(prob.insert(2));
    }
}
