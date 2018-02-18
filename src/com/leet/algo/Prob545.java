package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob545 {
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      Queue<TreeNode> temp = new LinkedList<>();
      boolean leftTaken = false;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (!leftTaken) {
          result.add(node.val);
          leftTaken = true;
        } else {
          if (queue.isEmpty()) rightList.add(0, node.val);
        }
        if (node.left != null) temp.add(node.left);
        if (node.right != null) temp.add(node.right);
      }
      queue = temp;
    }
    result.addAll(rightList);
    return result;
  }
}
