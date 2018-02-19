package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob545 {
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    result.add(root.val);
    leftBoundary(root.left, result);
    leaves(root.left, result);
    leaves(root.right, result);
    rightBoundary(root.right, result);
    return result;
  }

  private void leftBoundary(TreeNode root, List<Integer> result) {
    if (root == null || (root.left == null && root.right == null)) return;
    result.add(root.val);
    if (root.left != null) leftBoundary(root.left, result);
    else leftBoundary(root.right, result);
  }

  private void rightBoundary(TreeNode root, List<Integer> result) {
    if (root == null || (root.left == null && root.right == null)) return;
    if (root.right != null) rightBoundary(root.right, result);
    else rightBoundary(root.left, result);
    result.add(root.val);
  }

  private void leaves(TreeNode node, List<Integer> result) {
    if (node == null) return;
    if (node.left == null && node.right == null) result.add(node.val);
    leaves(node.left, result);
    leaves(node.right, result);
  }


}
