package com.leet.algo;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob250 {
  public int countUnivalSubtrees(TreeNode root) {
    int[] count = new int[1];
    helper(root, count);
    return count[0];
  }

  public boolean helper(TreeNode root, int[] count){
    if (root == null) return true;
    if (root.left == null && root.right == null) {
      count[0]++;
      return true;
    }
    // check not short-circuit and
    if (helper(root.left, count) & helper(root.right, count)){
      if ((root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
        count[0]++;
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Prob250 prob250 = new Prob250();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(prob250.countUnivalSubtrees(root));
  }


}
