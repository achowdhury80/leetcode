package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob783 {
  public int minDiffInBST(TreeNode root) {
    int result = Integer.MAX_VALUE;
    if (root == null || (root.left == null && root.right == null)) return result;
    TreeNode rightMost = null;
    if (root.left != null) {
      rightMost = findRightMost(root.left);
      result = Math.min(result, Math.abs(root.val - rightMost.val));
      result = Math.min(result, minDiffInBST(root.left));
    }
    TreeNode leftMost = null;
    if (root.right != null) {
      leftMost = findLeftMost(root.right);
      result = Math.min(result, Math.abs(root.val - leftMost.val));
      result = Math.min(result, minDiffInBST(root.right));
    }

    return result;
  }


  private TreeNode findRightMost(TreeNode root){
    if (root.right == null) return root;
    return findRightMost(root.right);
  }

  private TreeNode findLeftMost(TreeNode root){
    if (root.left == null) return root;
    return findLeftMost(root.left);
  }
}
