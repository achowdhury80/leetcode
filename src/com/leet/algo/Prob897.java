package com.leet.algo;
import java.util.*;
public class Prob897 {
	public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode result = new TreeNode(-1);
        TreeNode node = result;
        Iterator<TreeNode> itr = new InOrderIterator(root);
        while(itr.hasNext()) {
        	node.right = new TreeNode(itr.next().val);
        	node = node.right;
        }
        return result.right;
    }
	
	private class InOrderIterator implements Iterator<TreeNode> {
		private Stack<TreeNode> stack;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !stack.isEmpty();
		}

		@Override
		public TreeNode next() {
			// TODO Auto-generated method stub
			TreeNode returnNode = stack.pop();
			addToStack(returnNode.right);
			return returnNode;
		}
		
		InOrderIterator(TreeNode root) {
			stack = new Stack<>();
			addToStack(root);
		}
		
		private void addToStack(TreeNode node) {
			if (node == null) return;
			stack.push(node);
			while(node.left != null) {
				node = node.left;
				stack.push(node);
			}
		}
	}
	
	public static void main(String[] args) {
		Prob897 prob = new Prob897();
		TreeNode two = new TreeNode(2);
		two.left = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		three.left = two;
		three.right = new TreeNode(4);
		TreeNode eight = new TreeNode(8);
		eight.left = new TreeNode(7);
		eight.right = new TreeNode(9);
		TreeNode six = new TreeNode(6);
		six.right = eight;
		TreeNode root = new TreeNode(5);
		root.left = three;
		root.right = six;
		TreeNode result = prob.increasingBST(root);
		System.out.println(result);
	}
}
