package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob156 {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) return null;
    if(root.left == null) return root;
    TreeNode node = upsideDownBinaryTree(root.left);
    TreeNode rightMost = node;
    while (rightMost.right != null) rightMost = rightMost.right;
    rightMost.left = root.right;
    root.right = null;
    rightMost.right = root;
    root.left = null;
    return node;
  }

  public static void main(String[] args) {
    Prob156 prob156 = new Prob156();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(prob156.upsideDownBinaryTree(root));
  }
}
