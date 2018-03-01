package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int temp = (root.val - p.val) * (root.val - q.val);
    if (temp <= 0) return root;
    return p.val > root.val ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
  }
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
    Prob235 prob235 = new Prob235();
    TreeNode treeNode2 = prob235.new TreeNode(2);
    TreeNode treeNode1 = prob235.new TreeNode(1);
    treeNode2.left = treeNode1;
    System.out.println(prob235.lowestCommonAncestor(treeNode2, treeNode2, treeNode1));
  }
}
