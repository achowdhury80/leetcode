package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob287 {
  public int findDuplicate(int[] nums) {
    TreeNode root = new TreeNode(nums[0]);
    for(int i = 1; i < nums.length; i++){
      TreeNode node = root;
      int val = nums[i];
      while (true){
        if(node.val == val) return val;
        if(val < node.val) {
          if(node.left == null){
            TreeNode newNode = new TreeNode(val);
            node.left = newNode;
            break;
          } else node = node.left;
        } else {
          if(node.right == null){
            TreeNode newNode = new TreeNode(val);
            node.right = newNode;
            break;
          } else node = node.right;
        }
      }
    }
    return -1;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
      this.val = val;
    }
  }
}
