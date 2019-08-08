package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 8/15/17.
 */
public class Prob653 {

  public boolean findTarget(TreeNode root, int k) {
    if(root == null || (root.left == null && root.right == null)) return false;
    Set<Integer> neededSet = new HashSet<>();
    return findTarget(root, k, neededSet);

  }

  public boolean findTarget(TreeNode root, int k, Set<Integer> neededSet){
    if(root == null) return false;
    if(neededSet.contains(root.val)) return true;
    neededSet.add(k - root.val);
    return findTarget(root.left, k, neededSet) || findTarget(root.right, k, neededSet);
  }
}