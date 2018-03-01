package com.leet.algo;

/**
 * Created by ayanc on 10/18/17.
 */
public class Prob437 {
  public int pathSum(TreeNode root, int sum) {
    if(root == null) return 0;
    return (root.val == sum ? 1 : 0) + pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val)
        + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
}
