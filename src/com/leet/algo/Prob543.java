package com.leet.algo;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob543 {
  public static void main(String[] args){
    Prob543 prob543 = new Prob543();
    TreeNode root = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    root.left = two;
    root.right = three;
    two.left = four;
    two.right = five;
    System.out.println(prob543.diameterOfBinaryTree(root));
  }
  public int diameterOfBinaryTree(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 0;
    int leftChildDiameter = diameterOfBinaryTree(root.left);
    int rightChildDiameter = diameterOfBinaryTree(root.right);
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    int sumDepth = leftDepth + rightDepth + 2;
    int maxChildDiameter = leftChildDiameter > rightChildDiameter ? leftChildDiameter : rightChildDiameter;
    return sumDepth > maxChildDiameter ? sumDepth : maxChildDiameter;
  }

  private int maxDepth(TreeNode root){
    if(root == null) return -1;
    if(root.left == null && root.right == null) return 0;
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    if(leftDepth > rightDepth) return  leftDepth + 1;
    return rightDepth + 1;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
