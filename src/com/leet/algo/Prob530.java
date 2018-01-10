package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob530 {
  public int getMinimumDifference(TreeNode root) {
    if(root.left == null && root.right == null) return Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;
    if(root.left != null) {
      int subDiff = getMinimumDifference(root.left);
      TreeNode node = root.left;
      while(node.right != null) node = node.right;
      diff = Math.min(subDiff, Math.abs(node.val - root.val));
    }
    if(root.right != null) {
      diff = Math.min(diff, getMinimumDifference(root.right));
      TreeNode node = root.right;
      while(node.left != null) node = node.left;
      diff = Math.min(diff, Math.abs(node.val - root.val));
    }
    return diff;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
    Prob530 prob530 = new Prob530();
    TreeNode five = prob530.new TreeNode(5);
    TreeNode four = prob530.new TreeNode(4);
    TreeNode seven = prob530.new TreeNode(7);
    five.right = seven;
    five.left = four;
    System.out.println(prob530.getMinimumDifference(five));
  }


}


