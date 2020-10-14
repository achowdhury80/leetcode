package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob100 {
	/**
	 * O(N) time an space
	 * @param p
	 * @param q
	 * @return
	 */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == q) return true;
    if(p == null || q == null) return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
