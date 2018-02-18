package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob663 {
  public boolean checkEqualTree(TreeNode root) {
    if (root == null) return false;
    Set<Integer> set = new HashSet<>();
    int leftSum = findSum(root.left, set);
    int rightSum = findSum(root.right, set);
    int sum = root.val + leftSum + rightSum;
    return sum % 2 == 0 && set.contains(sum/2);
  }

  public int findSum(TreeNode node, Set<Integer> set) {
    if (node == null) return 0;
    int leftSum = findSum(node.left, set);
    int rightSum = findSum(node.right, set);
    int result = node.val + leftSum + rightSum;
    set.add(result);
    return result;
  }
}
