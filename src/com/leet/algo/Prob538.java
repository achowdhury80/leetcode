package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob538 {
  int lastVal = 0;
  public static void main(String[] args){
    Prob538 prob538 = new Prob538();
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7);
    TreeNode eight = new TreeNode(8);
    seven.left = six;
    seven.right = eight;

    three.left = two;
    three.right = four;
    five.left = three;
    five.right = seven;
    TreeNode result = prob538.convertBST(five);
    prob538.traverse(result);
  }



  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode convertBST(TreeNode root) {
    if(root == null) return null;
    TreeNode newNodeRight = convertBST(root.right);
    TreeNode newNodeRoot = new TreeNode(lastVal = root.val + lastVal);
    TreeNode newNodeLeft = convertBST(root.left);
    newNodeRoot.left = newNodeLeft;
    newNodeRoot.right = newNodeRight;
    return newNodeRoot;

  }

  private void traverse(TreeNode root) {
    if(root == null) return;
    System.out.print(root.val + ",");
    traverse(root.left);
    traverse(root.right);

  }

  private TreeNode trav(TreeNode root){
    if(root == null) return null;
    TreeNode newNodeRight = trav(root.right);
    TreeNode newNodeRoot = new TreeNode(lastVal = root.val + lastVal);
    TreeNode newNodeLeft = trav(root.left);
    newNodeRoot.left = newNodeLeft;
    newNodeRoot.right = newNodeRight;
    return newNodeRoot;
  }
}
