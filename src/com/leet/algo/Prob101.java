package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob101 {
  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode root1, TreeNode root2){
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;
    return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
  }
}
