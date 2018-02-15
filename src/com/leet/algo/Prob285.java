package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob285 {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;
    if (root.val <= p.val) return inorderSuccessor(root.right, p);
    TreeNode left = inorderSuccessor(root.left, p);
    return left == null ? root : left;
  }
//  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//    if (root == null) return null;
//    Stack<TreeNode> stack = new Stack<>();
//    TreeNode node = root;
//    while (!stack.isEmpty() || node != null) {
//      if (node == null) {
//        node = stack.pop();
//        node = node.right;
//      } else {
//        if (node == p) {
//          if (node.right != null) {
//            node = node.right;
//            while (node.left != null) node = node.left;
//            return node;
//          }
//          if (!stack.isEmpty()) return stack.pop();
//          return null;
//        }
//        stack.push(node);
//        node = node.left;
//      }
//    }
//    return null;
//  }
}
