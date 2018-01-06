package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob98 {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Integer.MIN_VALUE - 1l, Integer.MAX_VALUE + 1l);
  }

  public boolean isValidBST(TreeNode root, long lower, long upper) {
    if(root == null) return true;
    if(root.val < lower  || root.val > upper) return false;
    return isValidBST(root.left, lower, root.val - 1l) && isValidBST(root.right, root.val + 1l, upper);
  }
}
