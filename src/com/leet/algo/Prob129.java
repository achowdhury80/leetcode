package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob129 {
  public int sumNumbers(TreeNode root) {
    if(root == null) return 0;
    return sumNumbers(root, 0);
  }

  public int sumNumbers(TreeNode root, int prev){
    if(root == null) return prev;
    if(root.left == null && root.right == null) return prev * 10 + root.val;
    int result = 0;
    if(root.left != null) result += sumNumbers(root.left, prev * 10 + root.val);
    if(root.right != null) result += sumNumbers(root.right, prev * 10 + root.val);
    return result;
  }


}
