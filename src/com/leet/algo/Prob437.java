package com.leet.algo;

/**
 * Created by ayanc on 10/18/17.
 */
public class Prob437 {
  public int pathSum(TreeNode root, int sum) {
    if(root == null) return 0;
    int result = 0;
    if(root.val == sum) result++;
    else result += (pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val));
    result += pathSum(root.left, sum);
    result += pathSum(root.right, sum);
    return result;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
}
