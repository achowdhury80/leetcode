package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob156 {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) return null;
    if(root.left == null) return root;
    TreeNode tempLeft = root.left;
    TreeNode tempRight = root.right;
    root.left = null;
    root.right = null;
    return upsideDownBinaryTree(tempLeft, tempRight, root);
  }

  private TreeNode upsideDownBinaryTree(TreeNode left, TreeNode right, TreeNode parent) {
    TreeNode tempLeft = left.left;
    TreeNode tempRight = left.right;
    TreeNode newNode = left;
    newNode.left = right;
    newNode.right = parent;
    if(tempLeft != null) return upsideDownBinaryTree(tempLeft, tempRight, newNode);
    return newNode;
  }

  public static void main(String[] args) {
    Prob156 prob156 = new Prob156();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(prob156.upsideDownBinaryTree(root));
  }
}
