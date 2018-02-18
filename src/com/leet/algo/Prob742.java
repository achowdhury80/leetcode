package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob742 {
  public int findClosestLeaf(TreeNode root, int k) {
    Map<TreeNode, TreeNode> backMap = new HashMap<>();
    TreeNode target = dfs(root, k, backMap);
    Queue<TreeNode> q = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    visited.add(target);
    q.add(target);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node.left == null && node.right == null) return node.val;
      if (node.left != null && visited.add(node.left)) q.offer(node.left);
      if (node.right != null && visited.add(node.right)) q.offer(node.right);
      if (backMap.containsKey(node) && visited.add(backMap.get(node))) q.offer(backMap.get(node));
    }
    return -1;
  }

  private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
    if (root.val == k) return root;
    if (root.left != null) {
      backMap.put(root.left, root);
      TreeNode left = dfs(root.left, k, backMap);
      if (left != null) return left;
    }
    if (root.right != null) {
      backMap.put(root.right, root);
      TreeNode right = dfs(root.right, k, backMap);
      if (right != null) return right;
    }
    return null;
  }

  public static void main(String[] args) {
    Prob742 prob742 = new Prob742();
    System.out.println(prob742.findClosestLeaf(new TreeNode(1), 1));
  }
}
