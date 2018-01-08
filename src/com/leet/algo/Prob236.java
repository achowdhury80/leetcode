package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob236 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : (right == null ? left : root);
  }


  public static void main(String[] args){
    Prob236 prob236 = new Prob236();
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    one.left = two;
    one.right = three;
    System.out.println(prob236.lowestCommonAncestor(one, two, three).val);
  }
}
