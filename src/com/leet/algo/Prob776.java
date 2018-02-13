package com.leet.algo;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob776 {
  public TreeNode[] splitBST(TreeNode root, int V) {
    TreeNode sP = new TreeNode(0);
    TreeNode bP = new TreeNode(0);
    splitBST(root, V, sP, bP);
    return new TreeNode[]{sP.right, bP.left};
  }

  private void splitBST(TreeNode node, int V, TreeNode sP, TreeNode bP) {
    if (node == null) return;
    if (node.val <= V) {
      sP.right = node;
      TreeNode right = node.right;
      node.right = null;
      splitBST(right, V, node, bP);
    } else {
      bP.left = node;
      TreeNode left = node.left;
      node.left = null;
      splitBST(left, V, sP, node);
    }
  }
}
