package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob563 {
  public int findTilt(TreeNode root) {
    if(root == null) return 0;
    Map<TreeNode, Integer> sumMap = new HashMap<>();
    return Math.abs(findSubtreeSum(sumMap, root.left) - findSubtreeSum(sumMap, root.right)) + findTilt(root.left)
        + findTilt(root.right);
  }

  private int findSubtreeSum(Map<TreeNode, Integer> sumMap, TreeNode node){
    if(node == null) return 0;
    if(sumMap.containsKey(node)) return sumMap.get(node);
    sumMap.put(node, node.val + findSubtreeSum(sumMap, node.left) + findSubtreeSum(sumMap, node.right));
    return sumMap.get(node);
  }
}
