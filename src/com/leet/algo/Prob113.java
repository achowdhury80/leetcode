package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob113 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) return result;
    traverse(root, new ArrayList<>(), sum, result);
    return result;
  }

  private void traverse(TreeNode node, List<Integer> path, int targetSum, List<List<Integer>> result){
    List<Integer> newPath = new ArrayList<>(path);
    newPath.add(node.val);
    targetSum -= node.val;
    if(node.left == null && node.right == null){
      if(targetSum == 0) result.add(newPath);
    }
    if(node.left != null) traverse(node.left, newPath, targetSum, result);
    if(node.right != null) traverse(node.right, newPath, targetSum, result);
  }
}
