package com.prep2020.hard;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem431 {
	
	// Encodes an n-ary tree to a binary tree.
	// link the children by right node. set parent left node to point to first child
    public TreeNode encode(Node root) {
    	if (root == null) return null;
        TreeNode tRoot = new TreeNode(root.val);
        if (root.children != null && root.children.size() > 0) {
        	TreeNode head = new TreeNode(-1);
        	TreeNode cur = head;
        	for (Node child : root.children) {
        		TreeNode tNode = encode(child);
        		cur.right = tNode;
        		cur = cur.right;
        	}
        	tRoot.left = head.right;
        }
        return tRoot;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node dummy = new Node(-1);
        decodeHelper(root, dummy);
        return dummy.children.get(0);
    }
    
    private void decodeHelper(TreeNode root, Node parent) {
        if (root == null) return;
        TreeNode cur = root;
        parent.children = new ArrayList<>();
        while(cur != null) {
        	Node node = new Node(cur.val);
        	if (cur.left != null) decodeHelper(cur.left, node);
        	parent.children.add(node);
        	cur = cur.right;
        }
    }
    
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    public static void main(String[] args) {
    	Problem431 problem = new Problem431();
    	Node rNode = new Node(1);
    	Node five = new Node(5);
    	Node six = new Node(6);
    	Node three = new Node(3);
    	three.children = new ArrayList<>();
    	three.children.add(five);
    	three.children.add(six);
    	rNode.children = new ArrayList<>();
    	rNode.children.add(three);
    	rNode.children.add(new Node(4));
    	rNode.children.add(new Node(5));
    	TreeNode tRoot = problem.encode(rNode);
    	System.out.println(tRoot);
    	Node decodedNode = problem.decode(tRoot);
    	System.out.println(decodedNode);
    	
    }
}
