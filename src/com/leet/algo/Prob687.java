package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob687 {
  public int longestUnivaluePath(TreeNode root) {
    if(root == null) return 0;
    int[] res = new int[1];
    dfs(root, res);
    return res[0];
  }

  private int dfs(TreeNode root, int[] res){
    int left = 0, right = 0;
    if(root.left != null) left = dfs(root.left, res);
    if(root.right != null) right = dfs(root.right, res);
    left = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
    right = (root.right != null && root.val == root.right.val) ?  right + 1 : 0;
    res[0] = Math.max(res[0], left + right);
    return Math.max(left, right);
  }
}
