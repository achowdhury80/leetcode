package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob572 {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s == t) return true;
    if(s == null || t == null) return false;
    if(isSameTree(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t)) return true;
    return false;
  }

  private boolean isSameTree(TreeNode s, TreeNode t){
    if(s == t) return true;
    if(s == null || t == null) return false;
    return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
  }
}
