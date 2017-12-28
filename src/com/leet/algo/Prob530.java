package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob530 {
  private Integer lastViewed = null;
  private Integer minDiff = null;
  public int getMinimumDifference(TreeNode root) {
    if(root == null) return 0;
    trav(root);
    return minDiff;
  }

  private void trav(TreeNode root){
    if(root.left != null) trav(root.left);
    if(lastViewed == null){
      lastViewed = root.val;
    }else {
      int diff = Math.abs(root.val - lastViewed);
      if(minDiff == null || minDiff > diff){
        minDiff = diff;
      }
    }
    if(root.right != null) trav(root.right);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
    Prob530 prob530 = new Prob530();
    TreeNode one = prob530.new TreeNode(1);
    TreeNode three = prob530.new TreeNode(3);
    TreeNode two = prob530.new TreeNode(2);
    one.right = three;
    three.left = two;
    System.out.println(prob530.getMinimumDifference(one));
  }


}


