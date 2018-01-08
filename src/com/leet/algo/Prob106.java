package com.leet.algo;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob106 {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) return null;
    return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart,
                             int postorderEnd){
    TreeNode root = new TreeNode(postorder[postorderEnd]);
    int rootIndexInInOrder = -1;
    for(int i = inorderStart; i <= inorderEnd; i++){
      if(inorder[i] == root.val) {
        rootIndexInInOrder = i;
        break;
      }
    }
    int leftTreeSize = rootIndexInInOrder - inorderStart;
    int rightTreeSize = inorderEnd - rootIndexInInOrder;
    if(rightTreeSize > 0){
      root.right = buildTree(inorder, rootIndexInInOrder + 1, inorderEnd, postorder, postorderEnd - rightTreeSize, postorderEnd - 1);
    }
    if(leftTreeSize > 0){
      root.left = buildTree(inorder, inorderStart, rootIndexInInOrder - 1, postorder, postorderStart, postorderStart + leftTreeSize - 1);
    }
    return root;
  }

  public static void main(String[] args){
    Prob106 prob106 = new Prob106();
    System.out.println(prob106.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
  }
}
