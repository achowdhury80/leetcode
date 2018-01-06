package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob687 {
  public int longestUnivaluePath(TreeNode root) {
    if(root == null) return 0;
    int path1Val = longestUnivaluePath(root, root.val);
    int leftPathVal = longestUnivaluePath(root.left);
    int rightPathVal = longestUnivaluePath(root.right);
    if(path1Val > leftPathVal && path1Val > rightPathVal) return path1Val;
    if(leftPathVal > rightPathVal) return leftPathVal;
    return rightPathVal;
  }

  public int longestUnivaluePath(TreeNode root, int val) {
    int result = 0;
    if(root.val == val) return 0;
    if(root.val == val) result++;
    return result - 1;
  }
}
