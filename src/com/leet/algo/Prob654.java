package com.leet.algo;

/**
 * Created by ayanc on 11/13/17.
 */
public class Prob654 {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    TreeNode root = new TreeNode(nums[0]);
    for(int i = 1; i < nums.length; i++){
      root = addNumber(root, nums[i]);
    }

    return root;
  }

  private TreeNode addNumber(TreeNode root, int num){
    TreeNode numNode = new TreeNode(num);
    if(num > root.val){
      numNode.left = root;
      return numNode;
    }
    TreeNode parent = findParent(root, numNode);
    if(parent.right == null){
      parent.right = numNode;
    } else {
      numNode.left = parent.right;
      parent.right = numNode;
    }
    return root;
  }

  private TreeNode findParent(TreeNode root, TreeNode numNode){
    TreeNode parent = root;
    while(parent.right != null && parent.right.val > numNode.val){
      parent = parent.right;
    }
    return parent;
  }
}
