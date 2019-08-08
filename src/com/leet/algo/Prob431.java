package com.leet.algo;
import java.util.*;
public class Prob431 {
	 public TreeNode encode(Node root) {
	      return encode(root, true);  
	 }
	 
	 private TreeNode encode(Node root, boolean right) {
		 if (root == null) return null;
		 TreeNode r = new TreeNode(root.val);
		 TreeNode cur = r;
		 for (Node child : root.children) {
			 if (right) {
				 cur.right = encode(child, !right);
				 cur = cur.right;
			 } else {
				 cur.left = encode(child, !right);
				 cur = cur.left;
			 }
		 }
		 return r;
	 }

	    // Decodes your binary tree to an n-ary tree.
	public Node decode(TreeNode root) {
		return decode(root, true);
	}
	
	private Node decode(TreeNode root, boolean right) {
		if (root == null) return null;
		Node r = new Node();
		r.val = root.val;
		List<Node> children = new ArrayList<>();
		TreeNode cur = null;
		if (right && root.right != null) cur = root.right;
		else if (!right && root.left != null) cur = root.left;
		if (cur != null) {
			while(cur != null) {
				children.add(decode(cur, !right));
				if(right) cur = cur.right;
				else cur = cur.left;
			}
		}
		r.children = children;
		return r;
	}
	
	public static void main(String[] args) {
		Prob431 prob = new Prob431();
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);
		Node node3 = new Node(3, null);
		Node node2 = new Node(2, null);
		Node node4 = new Node(4, null);
		Node root = new Node(1, null);
		node3.children = Arrays.asList(new Node[] {node5, node6});
		root.children = Arrays.asList(new Node[] {node3, node2, node4});
		TreeNode t = prob.encode(root);
		Node node = prob.decode(t);
		System.out.println(t);
	}
}
