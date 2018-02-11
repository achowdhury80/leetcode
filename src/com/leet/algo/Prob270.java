package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob270 {
  public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode kid = root.val > target ? root.left : root.right;
    if (kid == null) return a;
    int b = closestValue(kid, target);
    return Math.abs(a - target) > Math.abs(b - target) ? b : a;
  }
}
