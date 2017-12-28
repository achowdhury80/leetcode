package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob501 {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int[] findMode(TreeNode root) {
    if(root == null) return null;
    Map<Integer, Integer> map = new HashMap<>();
    traverse(root, map);
    List<Integer> resultList = new ArrayList<>();
    return null;
  }

  private void traverse(TreeNode root, Map<Integer, Integer> map){
    if(map.containsKey(root.val)){
      map.put(root.val, map.get(root.val) + 1);
    } else {
      map.put(root.val, 1);
    }
    if(root.left != null) traverse(root.left, map);
    if(root.right != null) traverse(root.right, map);
  }

}
