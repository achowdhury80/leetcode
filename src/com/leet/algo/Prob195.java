package com.leet.algo;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob195 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
    return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inOrderStart,
                             int inOrderEnd){
    if(preOrderStart == preOrderEnd) return new TreeNode(preorder[preOrderStart]);
    TreeNode root = new TreeNode(preorder[preOrderStart]);
    int rootIndexInInOrder = -1;
    for(int i = inOrderStart; i <= inOrderEnd; i++){
      if(inorder[i] == root.val) {
        rootIndexInInOrder = i;
        break;
      }
    }
    if(rootIndexInInOrder - inOrderStart > 0){
      root.left = buildTree(preorder, preOrderStart + 1, preOrderStart + rootIndexInInOrder - inOrderStart, inorder,
          inOrderStart, rootIndexInInOrder - 1);
    }
    if(inOrderEnd - rootIndexInInOrder > 0){
      root.right = buildTree(preorder, preOrderStart + rootIndexInInOrder - inOrderStart + 1, preOrderEnd, inorder,
          rootIndexInInOrder + 1, inOrderEnd);
    }
    return root;
  }
}
