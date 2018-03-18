package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob226 {
  public TreeNode invertTree(TreeNode root) {
    if(root == null) return null;
    TreeNode left = root.left;
    root.left = root.right;
    root.right = left;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }
}
