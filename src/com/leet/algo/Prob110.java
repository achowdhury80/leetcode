package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob110 {
  public boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  private int height(TreeNode root) {
    if (root == null) return 0;
    int lh = height(root.left);
    int rh = height(root.right);
    if (lh == -1 || rh == -1 || lh - rh < -1 || lh - rh > 1) return -1;
    return Math.max(lh, rh) + 1;
  }
}
